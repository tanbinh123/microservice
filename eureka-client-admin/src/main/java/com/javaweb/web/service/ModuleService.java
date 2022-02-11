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
    
    List<ModuleIdAndNameResponse> getModuleIdAndNameList(String moduleType);
	
	List<Module> getModule(String userId);
	
	Page moduleList(ModuleListRequest moduleListRequest);
	
	void moduleDelete(String moduleIds[]);
	
	void moduleAdd(User user,ModuleAddRequest moduleAddRequest);
	
	void moduleModify(User user,ModuleModifyRequest moduleModifyRequest);
	
	Module moduleDetail(String moduleId);
	
	List<Role> getAllRoleByModuleId(String moduleId);
	
	List<User> getAllUserByModuleId(String moduleId);
	
	List<Module> getModuleByParentId(String parentId);

}
