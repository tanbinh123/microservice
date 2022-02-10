package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceCityDistrictAllResponse implements Serializable {

	private static final long serialVersionUID = 1897066731227942746L;

	private String province;//省值
	
	private String city;//市值
	
	private String district;//区值
	
	public ProvinceCityDistrictAllResponse(){
		
	}
	
	public ProvinceCityDistrictAllResponse(String province,String city,String district){
		this.province = province;
		this.city = city;
		this.district = district;
	}
	
}
