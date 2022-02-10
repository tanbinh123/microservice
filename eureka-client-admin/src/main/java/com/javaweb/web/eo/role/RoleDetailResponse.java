package com.javaweb.web.eo.role;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDetailResponse implements Serializable {

	private static final long serialVersionUID = -946613953559784113L;

	private String roleName;//角色名称
	
	private String roleCode;//角色代码
	
	private String remark;//备注

}
