package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.roleRestrict.ProvinceCityDistrictAllResponse;
import com.javaweb.web.eo.roleRestrict.RoleRestrictAddRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictModifyRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;
import com.javaweb.web.po.RoleRestrict;
import com.javaweb.web.po.User;

public interface RoleRestrictService {
	
	boolean roleRestrictIntersect(String province,String city,String district,String roleId,Integer restrictWay);
	
	void roleRestrictAdd(RoleRestrictAddRequest roleRestrictAddRequest,User user);
	
	RoleRestrict roleRestrictDetail(String roleRestrictId);

	void roleRestrictModify(RoleRestrictModifyRequest roleRestrictModifyRequest,User user);
	
	void roleRestrictDelete(String roleRestrictId);
	
	Page roleRestrictList(RoleRestrictListRequest roleRestrictListRequest);
	
	List<ProvinceCityDistrictAllResponse> mergeSSQResponseList(List<ProvinceCityDistrictAllResponse> list);
	
	String getPrivilegeCode(/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
	boolean personalInOrganize(boolean containsPersonal,User user,List<ProvinceCityDistrictAllResponse> list);
	
	List<ProvinceCityDistrictAllResponse> getOverlayList(User user,List<ProvinceCityDistrictAllResponse> list);
	
	RoleRestrictResponse roleRestrict(User user,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
	RoleRestrictResponse roleRestrict(User user,String privilegeCode,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
}
