package com.javaweb.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.javaweb.base.BaseInject;
import com.javaweb.base.BaseService;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.util.core.HttpUtil;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.po.Interfaces;
import com.javaweb.web.po.OperationLog;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
操作日志记录常见的有三种方式
1、正则URL路径规则
2、数据库URL开关控制
3、Controller注解标记
这里采用的是数据库URL开关控制
*/
@Aspect
@Component
public class OperateLogAspect extends BaseService {
	
	@Around(value=SystemConstant.DEFAULT_LOG_POINT_CUT)
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		Object object = joinPoint.proceed();//object instanceof BaseResponseResult
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		//Interfaces interfaces = BaseSystemMemory.getMatchRequestMapping(httpServletRequest);
		Interfaces interfaces = (Interfaces)httpServletRequest.getAttribute(SystemConstant.REQUEST_URL_CHAIN_ATTRIBUTE_NAME);
		if(interfaces!=null&&interfaces.getLogRecord()!=null&&interfaces.getLogRecord()==1){
			saveOperationLog(httpServletRequest,interfaces.getUrl(),joinPoint);
		}
		return object;
	}
	
	private void saveOperationLog(HttpServletRequest httpServletRequest,String baseUrl,ProceedingJoinPoint joinPoint){
		String url = httpServletRequest.getRequestURL().toString();
		//获得请求参数（一般指controller方法里的所有参数）
		String requestParameter = null;
		Object obj[] = joinPoint.getArgs();
		if(joinPoint!=null&&obj!=null){
			for(int i=0;i<obj.length;i++){
				if(obj[i] instanceof BindingResult || obj[i] instanceof TokenData || obj[i] instanceof HttpServletRequest || obj[i] instanceof HttpServletResponse) {
					continue;
				}
				try{
					requestParameter = JSONObject.fromObject(obj[i]).toString();
				}catch(Exception e1){
					try{
						requestParameter = JSONArray.fromObject(obj[i]).toString();
					}catch(Exception e2){
						//do nothing
					}
				}
			}
		}
		OperationLog operationLog = new OperationLog();
		operationLog.setId(idGenerator.idCreate());
		operationLog.setUrl(url);
		operationLog.setBaseUrl(baseUrl);
		operationLog.setRequestMethod(httpServletRequest.getMethod());
		operationLog.setRequestParameter(requestParameter/*joinPoint.getArgs().toString()*//*joinPoint.getSignature()*/);
		operationLog.setRequestIpAddress(HttpUtil.getIpAddress(httpServletRequest));
		operationLog.setRequestTime(new Date());
		TokenData tokenData = BaseInject.getTokenData(BaseInject.getToken(httpServletRequest));
		if(tokenData!=null){
			operationLog.setUserId(tokenData.getUser().getUserId());
			operationLog.setLoginWay(tokenData.getLoginWay());
			operationLog.setClientType(tokenData.getClientType());
		}else{
			operationLog.setUserId(CommonConstant.ZERO_STRING_VALUE);//0表示无需登录即可访问
			operationLog.setLoginWay(1);//默认账号密码登录
			operationLog.setClientType(1);//默认页面端
		}
		operationLogService.saveOperationLog(operationLog);//记录操作日志
	}
	
}
