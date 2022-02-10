package com.javaweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//APP端总拦截器（写法参考@Link(WebPermissionInterceptor)）
@Component
public class AppPermissionInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
		return true;
    }
	
}
