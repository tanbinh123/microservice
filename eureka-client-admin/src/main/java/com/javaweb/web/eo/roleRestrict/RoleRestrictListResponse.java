package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRestrictListResponse implements Serializable {

	private static final long serialVersionUID = -3810015181540030431L;
	
	private String id;//主键ID

	private String roleName;//角色名称
	
	private String province;//省（不限为all，本省为self）
	
	private String city;//市（不限为all，本市为self）
	
	private String district;//区（不限为all，本区为self）
	
	private String restrictWay;//限定方式（1：本人，本人的话省市区都为self；2：非本人，非本人的话会填充省市区）

}
