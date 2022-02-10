package com.javaweb.web.eo.interfaces;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterfaceInfoResponse implements Serializable {

	private static final long serialVersionUID = 7442190142948731110L;

	private String url;//URL通配
	
	private Integer requestDataSecret = 0;//请求数据加密（0：不加密；1：加密）
	
	private Integer responseDataSecret = 0;//返回数据加密（0：不加密；1：加密）
	
	public InterfaceInfoResponse(){
		
	}
	
	public InterfaceInfoResponse(String url,Integer requestDataSecret,Integer responseDataSecret){
		this.url = url;
		this.requestDataSecret = requestDataSecret;
		this.responseDataSecret = responseDataSecret;
	}
	
}
