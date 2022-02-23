package com.javaweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.javaweb.base.BaseInject;

@Component
public class ResponseHeaderFilter extends OncePerRequestFilter {
	
	//x.y.z：x为主版本号；y为次版本号（功能）；z为修订号（bug修复）
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException,IOException {
		response.addHeader(BaseInject.getEnvironment().getProperty("project.version.key"),BaseInject.getEnvironment().getProperty("project.version.value"));
		response.addHeader(BaseInject.getEnvironment().getProperty("project.code.key"),BaseInject.getEnvironment().getProperty("project.code.value"));
		response.addHeader(BaseInject.getEnvironment().getProperty("project.name.key"),BaseInject.getEnvironment().getProperty("project.name.value"));
		filterChain.doFilter(request,response);
	}

}
