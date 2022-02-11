package com.javaweb.web.service;

import java.util.List;

import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;

public interface CityService {
	
	List<ProvinceCityDistrictResponse> getCityList(String provinceCode,RoleRestrictResponse roleRestrictResponse);
	
	boolean isExistBySelectProvinceAndCityCode(String provinceCode,String cityCode);

}
