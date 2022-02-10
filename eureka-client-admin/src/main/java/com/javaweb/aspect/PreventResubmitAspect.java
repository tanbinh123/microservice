package com.javaweb.aspect;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.javaweb.annotation.url.PreventResubmit;
import com.javaweb.base.BaseInject;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.HttpUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.po.Interfaces;

//原理上与@see com.javaweb.filter.InterfaceLimitFilter 类似
@Aspect
@Component
public class PreventResubmitAspect extends BaseInject {
	
	private final Logger LOG = LoggerFactory.getLogger(PreventResubmitAspect.class);
	
	@Pointcut("@annotation(preventResubmit)")
	public void pointcut(PreventResubmit preventResubmit) { 
		
	}
	
	@Around("pointcut(preventResubmit)")
	public Object arround(ProceedingJoinPoint proceedingJoinPoint,PreventResubmit preventResubmit) throws Throwable {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		String url = httpServletRequest.getRequestURI();//url
		String parameter = httpServletRequest.getQueryString();//url后面的参数
		parameter = (parameter==null?CommonConstant.EMPTY_VALUE:parameter);
		Object[] body = proceedingJoinPoint.getArgs();//body
		String newBody = ((body==null||body.length==0)?CommonConstant.EMPTY_VALUE:body.toString());//这里参数极其简单的处理了，如有需要请自行详细处理
		LOG.info("url:"+url+",parameter:"+parameter+",body:"+newBody);
		Interfaces interfaces = (Interfaces)httpServletRequest.getAttribute(SystemConstant.REQUEST_URL_CHAIN_ATTRIBUTE_NAME);
		if(interfaces!=null){
			String key = CommonConstant.EMPTY_VALUE;
			TokenData tokenData = BaseInject.getTokenData(BaseInject.getToken(httpServletRequest));
			if((tokenData==null)||(tokenData.getUser()==null)||(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(tokenData.getUser().getUserId())))){
				key = HttpUtil.getIpAddress(httpServletRequest) + CommonConstant.POUND + (url+parameter+newBody);//禁IP
			}else{
				key = tokenData.getUser().getUserId() + CommonConstant.POUND + (url+parameter+newBody);//禁用户
			}
			boolean isSuccess = valueOperations.setIfAbsent(key,1,3,TimeUnit.SECONDS);//可以比如设置在3秒内不能重复提交表单
			if(isSuccess){
				return proceedingJoinPoint.proceed();
			}else{
				return getBaseResponseResult(HttpCodeEnum.PREVENT_RE_SUBMIT,"validated.permission.preventReSubmit");//表单重复提交了
			}
		}
		return proceedingJoinPoint.proceed();
	}

}
