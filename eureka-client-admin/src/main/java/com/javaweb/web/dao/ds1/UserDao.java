package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.user.RoleInfoResponse;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.eo.user.UserListResponse;
import com.javaweb.web.po.User;

@Mapper
public interface UserDao extends DaoWapper<User> {
	
	List<UserListResponse> userList(UserListRequest userListRequest);
	
	Long userListCount(UserListRequest userListRequest);
	
	void userDelete(String userId);
	
	List<User> getUsersByUserId(List<String> list);
	
	List<RoleInfoResponse> userRoleInfo(String userId);
	
	void userRoleAssignment(Map<String,Object> map);
	
	List<ModuleInfoResponse> userModuleInfo(String userId);
	
	void userModuleAssignment(Map<String,Object> map);
	
}
