package com.javaweb.web.eo.role;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleModifyRequest implements Serializable {

	private static final long serialVersionUID = 5190263101115791813L;

	@NotEmpty(message="validated.role.roleId.notEmpty")
	private String roleId;//角色ID
	
	@NotEmpty(message="validated.role.roleName.notEmpty")
	@Size(max=20,message="validated.role.roleName.maxLength.limit")
	private String roleName;//角色名称
	
	@NotEmpty(message="validated.role.roleCode.notEmpty")
	@Size(max=20,message="validated.role.roleCode.maxLength.limit")
	private String roleCode;//角色代码
	
	@Size(max=100,message="validated.role.remark.maxLength.limit")
	private String remark;//备注
	
}
