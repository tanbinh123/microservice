package com.javaweb.web.eo.role;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleListAllRequest implements Serializable {

	private static final long serialVersionUID = 1203936138205283128L;

	private String roleId;

	private String roleName;
	
}
