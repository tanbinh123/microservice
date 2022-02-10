package com.javaweb.web.eo.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListResponse implements Serializable {
	
	private static final long serialVersionUID = -7480353722420364562L;

	private String userId;//用户ID
	
	private String userName;//用户名
	
	private String personName;//用户姓名
	
	private Integer status;//账号状态
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createDate;//注册日期
	
	private String roleName;//角色名称
	
	private String province;//省（不限为all，本省为self）
	
	private String city;//市（不限为all，本市为self）
	
	private String district;//区（不限为all，本区为self）
	
}
