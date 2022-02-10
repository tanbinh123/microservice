package com.javaweb.web.service;

import java.util.List;

import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;

public interface ProvinceService {
	
	public List<ProvinceCityDistrictResponse> getProvinceList(RoleRestrictResponse roleRestrictResponse);
	
	public boolean isExistBySelectProvinceCode(String provinceCode);

}
