package com.javaweb.interceptor;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseInject;
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.util.core.StringUtil;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.po.Interfaces;

//权限拦截器
@Component
public class WebPermissionInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {//本方法异常不应该主动抛出
		if(request.getMethod().toUpperCase().equals("OPTIONS")){
            return true;//通过所有OPTIONS请求
        }
		AuthEnum authEnum = urlPermission(handler); 
		if(AuthEnum.NO_LOGIN==authEnum){
			return true;
		}
		TokenData tokenData = BaseInject.getTokenData(BaseInject.getToken(request)); 
		if((tokenData==null)||(tokenData.getUser()==null)||(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(tokenData.getUser().getUserId())))){
			request.getRequestDispatcher(ApiConstant.INVALID_REQUEST).forward(request,response);
			return false;
		}
		Long redisSessionTimeout = Long.parseLong(BaseInject.getEnvironment().getProperty("redis.session.timeout"));//获得配置文件中redis设置session失效的时间
		String redisTokenKey = BaseInject.getRedisTokenKey(tokenData);
		if(AuthEnum.LOGIN==authEnum){
			BaseInject.getRedisTemplate().opsForValue().set(redisTokenKey,tokenData,Duration.ofMinutes(redisSessionTimeout));
			return true;
		}
		//HandlerMethod handlerMethod = (HandlerMethod)handler;
		//String classMethod = handlerMethod.getBeanType().getName() + CommonConstant.POUND + handlerMethod.getMethod().getName();
		//classMethod.equals(interfaces.getClassMethod()
		Interfaces interfaces = (Interfaces)request.getAttribute(SystemConstant.REQUEST_URL_CHAIN_ATTRIBUTE_NAME);
		if(interfaces==null||interfaces.getUrl()==null||CommonConstant.EMPTY_VALUE.equals(interfaces.getUrl().trim())){
			request.getRequestDispatcher(ApiConstant.NO_AUTHORY).forward(request,response);
			return false;
		}
		String urls[] = interfaces.getUrl().split(CommonConstant.COMMA);//获得接口url通配列表
		List<String> apiUrlList = tokenData.getApiUrlList();//后端接口列表
		for(String url:urls){
			if(apiUrlList.contains(url)){
				BaseInject.getRedisTemplate().opsForValue().set(redisTokenKey,tokenData,Duration.ofMinutes(redisSessionTimeout));
				return true;
			}
		}
		request.getRequestDispatcher(ApiConstant.NO_AUTHORY).forward(request,response);
		return false;
	}
	
	private AuthEnum urlPermission(Object handler) {
	    if(handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod)handler).getMethod();
            //IgnoreUrl ignoreUrl = method.getAnnotation(IgnoreUrl.class);
            //AnnotatedElementUtils.isAnnotated(method,IgnoreUrl.class);
            ControllerMethod controllerMethod = (method.getAnnotation(ControllerMethod.class));
            if(controllerMethod==null){
            	return AuthEnum.NO_LOGIN;
            }else{
            	return controllerMethod.auth();
            }
        }
	    return AuthEnum.PERMISSION;
	}
	
}
