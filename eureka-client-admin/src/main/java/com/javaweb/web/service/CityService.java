package com.javaweb.web.service;

import java.util.List;

import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;

public interface CityService {
	
	public List<ProvinceCityDistrictResponse> getCityList(String provinceCode,RoleRestrictResponse roleRestrictResponse);
	
	public boolean isExistBySelectProvinceAndCityCode(String provinceCode,String cityCode);

}
