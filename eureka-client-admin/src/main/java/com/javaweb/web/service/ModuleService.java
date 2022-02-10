package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.module.ModuleAddRequest;
import com.javaweb.web.eo.module.ModuleIdAndNameResponse;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleModifyRequest;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.User;

public interface ModuleService {
    
    public List<ModuleIdAndNameResponse> getModuleIdAndNameList(String moduleType);
	
	public List<Module> getModule(String userId);
	
	public Page moduleList(ModuleListRequest moduleListRequest);
	
	public void moduleDelete(String moduleIds[]);
	
	public void moduleAdd(User user,ModuleAddRequest moduleAddRequest);
	
	public void moduleModify(User user,ModuleModifyRequest moduleModifyRequest);
	
	public Module moduleDetail(String moduleId);
	
	public List<Role> getAllRoleByModuleId(String moduleId);
	
	public List<User> getAllUserByModuleId(String moduleId);
	
	public List<Module> getModuleByParentId(String parentId);

}
