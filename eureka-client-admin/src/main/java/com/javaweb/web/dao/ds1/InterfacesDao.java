package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.interfaces.InterfacesListRequest;
import com.javaweb.web.eo.interfaces.RolePermissionResponse;
import com.javaweb.web.eo.interfaces.UserPermissionResponse;
import com.javaweb.web.eo.interfaces.UserRoleDataPermissionRequest;
import com.javaweb.web.po.Interfaces;

@Mapper
public interface InterfacesDao extends DaoWapper<Interfaces>{
	
	void interfacesBatchInsert(List<Interfaces> list);
	
	void interfacesBatchDelete(List<String> list);
	
	List<Interfaces> interfacesList(InterfacesListRequest interfacesListRequest);
	
	Long interfacesListCount(InterfacesListRequest interfacesListRequest);
	
	List<UserPermissionResponse> userPermissionList(UserRoleDataPermissionRequest userRoleDataPermissionRequest);
	
	Long userPermissionListCount(UserRoleDataPermissionRequest userRoleDataPermissionRequest);
	
	List<RolePermissionResponse> rolePermissionList(UserRoleDataPermissionRequest userRoleDataPermissionRequest);
	
	Long rolePermissionListCount(UserRoleDataPermissionRequest userRoleDataPermissionRequest);
	
	void clearUserRoleDataPermission(); 
	
	void deleteUserDataPermission(List<String> userIds);

	void deleteRoleDataPermission(List<String> roleIds);

}
