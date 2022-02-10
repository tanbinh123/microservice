package com.javaweb;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.javaweb.constant.SystemConstant;
import com.javaweb.filter.InterfaceLimitFilter;

@SpringBootApplication(exclude={
	DataSourceAutoConfiguration.class,//去除数据源默认配置
	RedisAutoConfiguration.class,RedisRepositoriesAutoConfiguration.class,//去除redis默认配置
	FreeMarkerAutoConfiguration.class//去除freemarker自动配置
})
@EnableEurekaClient//非Eureka只能用@EnableDiscoveryClient
@EnableFeignClients(basePackages={SystemConstant.BASE_PACKAGE})
@EnableScheduling//开启定时任务
@EnableAsync//开启异步任务
//@MapperScan("com.javaweb.web.dao")//这样写就不必在所有的dao接口上加@Mapper
public class Application {
	
    public static void main(String[] args) {
        //System.setProperty("es.set.netty.runtime.available.processors","false");//为了避免elasticsearch依赖的netty与netty冲突 
        //new MyCommandLineRunner();
        //SpringApplication.run(Application.class,args);//最简单的启动写法
    	SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Mode.OFF);
        //springApplication.addListeners(new ApplicationListener[]{new ApplicationEnvironmentListener()});
        springApplication.run(args);
    }
    
    /* -------------------------------------------------- 分界线 -------------------------------------------------- */
	
    //过滤器注入（@Link InterfaceLimitFilter）
    @Bean
    public FilterRegistrationBean<InterfaceLimitFilter> interfaceLimitFilter(){
        FilterRegistrationBean<InterfaceLimitFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new InterfaceLimitFilter());
        bean.addUrlPatterns(SystemConstant.URL_ALL_PATTERN);
        bean.setName(InterfaceLimitFilter.class.getSimpleName());//InterfaceLimitFilter
        bean.setOrder(1);
        return bean;
    }

}
