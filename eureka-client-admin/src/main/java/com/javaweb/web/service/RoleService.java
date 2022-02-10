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
	
	public Page roleList(RoleListRequest roleListRequest);
	
	public void roleDelete(String roleId);

	public void roleAdd(Role role);
	
	public void roleAdd(User currentUser,RoleAddRequest roleAddRequest);

	public void roleModify(Role role);
	
	public void roleModify(User currentUser,RoleModifyRequest roleModifyRequest);
	
	public Role roleDetail(String roleId);
	
	public List<ModuleInfoResponse> roleModuleInfo(String roleId);
	
	public void roleModuleAssignment(String roleId,List<String> list);
	
	public List<RoleListAllRequest> roleListAll();
	
}
