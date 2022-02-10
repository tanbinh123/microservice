package com.javaweb;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
					  //微服务调用示例：http://client3:2003/eureka-client-admin/web/sys/config/add
					  .route("eureka-client-admin",r->r.path("/admin/**").uri("lb://eureka-client-admin"))
					  .build();
	}

}
