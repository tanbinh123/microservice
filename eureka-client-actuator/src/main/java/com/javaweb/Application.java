package com.javaweb;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class Application {
	
    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Mode.OFF);
        springApplication.run(args);
    }

}
