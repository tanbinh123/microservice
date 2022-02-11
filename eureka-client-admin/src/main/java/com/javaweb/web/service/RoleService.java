package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.role.RoleAddRequest;
import com.javaweb.web.eo.role.RoleListAllRequest;
import com.javaweb.web.eo.role.RoleListRequest;
import com.javaweb.web.eo.role.RoleModifyRequest;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.User;

public interface RoleService {
	
	Page roleList(RoleListRequest roleListRequest);
	
	void roleDelete(String roleId);

	void roleAdd(Role role);
	
	void roleAdd(User currentUser,RoleAddRequest roleAddRequest);

	void roleModify(Role role);
	
	void roleModify(User currentUser,RoleModifyRequest roleModifyRequest);
	
	Role roleDetail(String roleId);
	
	List<ModuleInfoResponse> roleModuleInfo(String roleId);
	
	void roleModuleAssignment(String roleId,List<String> list);
	
	List<RoleListAllRequest> roleListAll();
	
}
