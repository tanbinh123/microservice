package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.module.ModuleIdAndNameResponse;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleListResponse;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.User;

@Mapper
public interface ModuleDao extends DaoWapper<Module> {
	
	List<Module> getModuleByModuleId(List<String> list);
	
	List<ModuleListResponse> moduleList(ModuleListRequest moduleListRequest);
	
	Long moduleListCount(ModuleListRequest moduleListRequest);
	
	void moduleDelete(String moduleId);
	
	Module moduleDetail(String moduleId);
	
	List<ModuleIdAndNameResponse> getModuleIdAndNameList(Map<String,String> map);
	
	List<Role> getAllRoleByModuleId(String moduleId);
	
	List<User> getAllUserByModuleId(String moduleId);
	
	void setModuleParentIdNull(Module module);
	
	List<Module> getModuleByParentId(String parentId);
	
	Long getOrders(Map<String,Object> map);
	
}
