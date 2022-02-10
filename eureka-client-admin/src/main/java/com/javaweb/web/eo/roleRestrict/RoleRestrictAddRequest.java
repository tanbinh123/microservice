package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRestrictAddRequest implements Serializable {

	private static final long serialVersionUID = 4981844315191907552L;

	@NotEmpty(message="validated.roleRestrict.roleId.notEmpty")
	private String roleId;//角色ID
	
	private String province;//省（不限为all，本省为self）
	
	private String city;//市（不限为all，本市为self）
	
	private String district;//区（不限为all，本区为self）
	
	@Min(value=1,message="validated.roleRestrict.restrictWay.limit")
	@Max(value=2,message="validated.roleRestrict.restrictWay.limit")
	private Integer restrictWay;//限定方式（1：本人，本人的话省市区都为self；2：非本人，非本人的话会填充省市区）
	
}
