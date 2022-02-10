package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRestrictResponse implements Serializable {

	private static final long serialVersionUID = -6639483766527121647L;

	private boolean containsPersonal;//是否包含个人
	
	private boolean personalInOrganize;//个人是否包含在组织内
	
	private List<ProvinceCityDistrictAllResponse> list;//机构部门科室列表
	
	public RoleRestrictResponse(){
		
	}
	
	public RoleRestrictResponse(boolean containsPersonal,boolean personalInOrganize,List<ProvinceCityDistrictAllResponse> list){
		this.containsPersonal = containsPersonal;
		this.personalInOrganize = personalInOrganize;
		this.list = list;
	}

}
