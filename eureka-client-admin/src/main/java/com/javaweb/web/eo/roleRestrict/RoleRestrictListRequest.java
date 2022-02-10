package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRestrictListRequest implements Serializable {

	private static final long serialVersionUID = 330607673594076826L;
	
	private String roleName;//角色名称
	
	private String province;//省（不限为all，本省为self）
	
	private String city;//市（不限为all，本市为self）
	
	private String district;//区（不限为all，本区为self）
	
	private Long currentPage = 1L;//默认当前第1页
	
	private Long pageSize = 10L;//默认每页显示10条

}
