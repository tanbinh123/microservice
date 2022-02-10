package com.javaweb.web.service;

import java.util.List;

import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;

public interface DistrictService {
	
	public List<ProvinceCityDistrictResponse> getDistrictList(String cityCode,RoleRestrictResponse roleRestrictResponse);
	
	public boolean isExistBySelectCityAndDistrictCode(String cityCode,String districtCode);

}
