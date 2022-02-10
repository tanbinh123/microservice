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
	
	public boolean roleRestrictIntersect(String province,String city,String district,String roleId,Integer restrictWay);
	
	public void roleRestrictAdd(RoleRestrictAddRequest roleRestrictAddRequest,User user);
	
	public RoleRestrict roleRestrictDetail(String roleRestrictId);

	public void roleRestrictModify(RoleRestrictModifyRequest roleRestrictModifyRequest,User user);
	
	public void roleRestrictDelete(String roleRestrictId);
	
	public Page roleRestrictList(RoleRestrictListRequest roleRestrictListRequest);
	
	public List<ProvinceCityDistrictAllResponse> mergeSSQResponseList(List<ProvinceCityDistrictAllResponse> list);
	
	public String getPrivilegeCode(/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
	public boolean personalInOrganize(boolean containsPersonal,User user,List<ProvinceCityDistrictAllResponse> list);
	
	public List<ProvinceCityDistrictAllResponse> getOverlayList(User user,List<ProvinceCityDistrictAllResponse> list);
	
	public RoleRestrictResponse roleRestrict(User user,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
	public RoleRestrictResponse roleRestrict(User user,String privilegeCode,/*HttpServletRequest httpServletRequest,*/String bestMatchingPattern);
	
}
