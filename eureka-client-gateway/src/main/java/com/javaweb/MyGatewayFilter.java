package com.javaweb;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class MyGatewayFilter implements GatewayFilter,Ordered {

	public int getOrder() {
		return 0;
	}

	public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
		//String path = exchange.getRequest().getPath().toString();
		//String ip = exchange.getRequest().getRemoteAddress().getHostString();
		return chain.filter(exchange);
	}
    
}
