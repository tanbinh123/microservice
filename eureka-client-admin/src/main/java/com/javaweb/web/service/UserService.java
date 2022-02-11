package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.role.RoleIdAndStrategyRequest;
import com.javaweb.web.eo.user.RoleInfoResponse;
import com.javaweb.web.eo.user.UserAddRequest;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.eo.user.UserLoginRequest;
import com.javaweb.web.eo.user.UserModifyRequest;
import com.javaweb.web.eo.user.UserModuleAssignmentRequest;
import com.javaweb.web.po.User;

public interface UserService {
	
	User userLogin(UserLoginRequest userLogin);
	
	Page userList(UserListRequest userListRequest);
	
	void userDelete(String userId);

	void userAdd(User user);

	void userAdd(User currentUser,UserAddRequest userAddRequest);

	void userModify(User user);
	
	void userModify(User currentUser,UserModifyRequest userModifyRequest);
	
	User userDetail(String userId);
	
	List<User> getUsersByUserId(List<String> list);
	
	List<RoleInfoResponse> userRoleInfo(String userId);
	
	void userRoleAssignment(String userId,List<RoleIdAndStrategyRequest> list);
	
	List<ModuleInfoResponse> userModuleInfo(String userId);
	
	void userModuleAssignment(UserModuleAssignmentRequest userModuleAssignmentRequest);
	
	List<User> getAllUsers();
	
	void userInitPassword(String userId,TokenData tokenData);
	
	//void userPortraitUpload(String userId,MultipartFile multipartFile);

	//void userPortrait(String userId,HttpServletResponse httpServletResponse);
	
}
