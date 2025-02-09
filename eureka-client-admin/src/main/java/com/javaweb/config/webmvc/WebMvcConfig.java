package com.javaweb.config.webmvc;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.javaweb.interceptor.WebPermissionInterceptor;
import com.javaweb.resolver.TokenDataHandlerMethodArgumentResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	/** 5.3.x不在需要显式设置了
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
    */

    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebPermissionInterceptor());
		//registry.addInterceptor(new WebPermissionInterceptor()).addPathPatterns("/web/**");//拦截/web下面的所有请求
    }
    
    //更加细化的可以在Controller中写为:@CrossOrigin(origins="http://192.168.1.100:8080",maxAge=3600)
    public void addCorsMappings(CorsRegistry corsRegistry) {
    	corsRegistry.addMapping("/**")
        	        .allowedOriginPatterns("*")//.allowedOrigins("*")//新版不适用了
        	        .allowedHeaders("*")
        	        .allowedMethods("*")
        	        //.exposedHeaders("token")//处理前端拿不到服务器response返回的header里key对应的value值
        	        .allowCredentials(true);
    }

    //这里主要是添加资源访问例外(http://IP:端口/项目名称/swagger-ui.html)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
    	//registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new TokenDataHandlerMethodArgumentResolver());
	}
    
}
