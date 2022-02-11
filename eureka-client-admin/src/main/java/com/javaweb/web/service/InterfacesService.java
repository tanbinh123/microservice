package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.interfaces.ExcludeInfoResponse;
import com.javaweb.web.eo.interfaces.InterfacesListRequest;
import com.javaweb.web.eo.interfaces.InterfacesTestRequest;
import com.javaweb.web.eo.interfaces.UserRoleDataPermissionRequest;
import com.javaweb.web.eo.interfaces.UserRolePermissionRequest;
import com.javaweb.web.po.Interfaces;
import com.javaweb.web.po.User;

public interface InterfacesService {
	
	void synchronizedInterfaces();
	
	Page interfacesList(InterfacesListRequest interfacesListRequest);
	
	Interfaces interfacesDetail(String interfacesId);
	
	void interfacesModify(Interfaces interfaces);
	
	Page userRoleDataPermission(UserRoleDataPermissionRequest userRoleDataPermissionRequest);
	
	void dataPermissionAssignment(UserRolePermissionRequest userRolePermissionResponse,String interfacesId,User user);
	
	List<ExcludeInfoResponse> getExcludeInfoResponseList(String userId);
	
	void synchronizedRedisInterfaceHistoryTimes();
	
	List<Interfaces> getAll();
	
	String interfacesTest(InterfacesTestRequest interfacesTestRequest);

}
