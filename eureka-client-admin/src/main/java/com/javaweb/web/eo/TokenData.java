package com.javaweb.web.eo;

import java.io.Serializable;
import java.util.List;

import com.javaweb.web.eo.interfaces.ExcludeInfoResponse;
import com.javaweb.web.eo.interfaces.InterfaceInfoResponse;
import com.javaweb.web.eo.module.SidebarInfoResponse;
import com.javaweb.web.po.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenData implements Serializable {
	
	private static final long serialVersionUID = -6256223897799749383L;

	private String token;//token
	
	private User user;//用户信息
	
	private Integer clientType;//客户端类型（@see OperationLog）

	private Integer loginWay;//登录方式（@see OperationLog）
	
	private String date;//yyyyMMddHHmmss

	private List<String> pageUrlList;//用于前端页面权限（粗粒度）

	private List<String> aliasList;//用于前端按钮权限（细粒度）

	private List<String> apiUrlList;//后端接口列表
	
	private List<SidebarInfoResponse> menuListForTree;//用于前端目录、菜单的树形结构封装
	
	private String rsaPublicKey1;//公钥1
	
	private String rsaPrivateKey1;//私钥1
	
	private String rsaPublicKey2;//公钥2
	
	private String rsaPrivateKey2;//私钥2
	
	private List<ExcludeInfoResponse> excludeInfoResponseList;
	
	private transient List<InterfaceInfoResponse> interfaceInfoResponseList;

	private transient String bestMatchingPattern;

	private transient String alias;
	
}
