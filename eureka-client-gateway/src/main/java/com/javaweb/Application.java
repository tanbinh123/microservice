package com.javaweb;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//非Eureka只能用@EnableDiscoveryClient
public class Application {
	
    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Mode.OFF);
        springApplication.run(args);
    }
    
	/**
    @Bean
    public KeyResolver ipKeyResolver(){
    	return exchange->Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
	*/

}
