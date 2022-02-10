package com.javaweb.web.eo.role;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleListResponse implements Serializable {
	
	private static final long serialVersionUID = -3589773690897290520L;

	private String roleId;//角色ID
	
	private String roleName;//角色名称
	
	private String roleCode;//角色代码
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createDate;//注册日期

}
