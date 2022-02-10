package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.role.RoleAddRequest;
import com.javaweb.web.eo.role.RoleListAllRequest;
import com.javaweb.web.eo.role.RoleListRequest;
import com.javaweb.web.eo.role.RoleListResponse;
import com.javaweb.web.eo.role.RoleModifyRequest;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.RoleModule;
import com.javaweb.web.po.User;
import com.javaweb.web.service.RoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseDao implements RoleService {
	
	@Override
	public Page roleList(RoleListRequest roleListRequest){
		List<RoleListResponse> list = roleDao.roleList(roleListRequest);
		long count = roleDao.roleListCount(roleListRequest);
		Page page = new Page(roleListRequest,list,count);
		return page;
	}

	@Transactional
	@Override
	public void roleDelete(String roleId) {
		String roleIds[] = roleId.split(CommonConstant.COMMA);
		for(String id:roleIds){
			roleDao.roleDelete(id);
		}
	}

	@Transactional
	@Override
	public void roleAdd(Role role) {
		roleDao.insert(role);
	}
	
	@Transactional
	@Override
	public void roleAdd(User currentUser,RoleAddRequest roleAddRequest) {
		Role role = new Role();
		ObjectOperateUtil.copyProperties(roleAddRequest,role);
		role.setSystemId(SystemConstant.SYSTEM_NO);
		role.setCreator(currentUser.getUserId());
		role.setCreateDate(new Date());
		roleDao.insert(role);
	}

	@Transactional
	@Override
	public void roleModify(Role role) {
		roleDao.update(role);
	}
	
	@Transactional
	@Override
	public void roleModify(User currentUser,RoleModifyRequest roleModifyRequest) {
		Role role = new Role();
		ObjectOperateUtil.copyProperties(roleModifyRequest,role);
		role.setUpdater(currentUser.getUserId());
		role.setUpdateDate(new Date());
		roleDao.update(role);
	}

	@Override
	public Role roleDetail(String roleId) {
		return roleDao.roleDetail(roleId);
	}

	@Override
	public List<ModuleInfoResponse> roleModuleInfo(String roleId) {
		List<ModuleInfoResponse> list = roleDao.roleModuleInfo(roleId);
		list = setTreeList(list,null);
		return list;
	}
	
	//封装成树形结构集合
	private List<ModuleInfoResponse> setTreeList(List<ModuleInfoResponse> originList,ModuleInfoResponse moduleInfoResponse){
		List<ModuleInfoResponse> moduleList = new ArrayList<>();
		for (int i = 0; i < originList.size(); i++) {
			ModuleInfoResponse currentModule = originList.get(i);
			if((moduleInfoResponse!=null&&moduleInfoResponse.getModuleId().equals(currentModule.getParentId()))||(moduleInfoResponse==null&&currentModule.getParentId()==null)){
				currentModule.setList(setTreeList(originList,currentModule));
				moduleList.add(currentModule);
			}
		}
		return moduleList;
	}

	@Transactional
	@Override
	public void roleModuleAssignment(String roleId,List<String> list) {
		Map<String,Object> map = new HashMap<>();
		List<RoleModule> roleModuleList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			RoleModule roleModule = new RoleModule();
			roleModule.setId(idGenerator.idCreate());
			roleModule.setRoleId(roleId);
			roleModule.setModuleId(list.get(i));
			roleModuleList.add(roleModule);
		}
		map.put("roleId",roleId);
		map.put("list",roleModuleList);
		roleDao.roleModuleAssignment(map);
	}

	@Override
	public List<RoleListAllRequest> roleListAll() {
		QueryWapper<Role> queryWapper = new QueryWapper<>();
		queryWapper.eq(Role.delFlagColumn,0);
		List<Role> sourceList = roleDao.selectList(queryWapper);
		return ObjectOperateUtil.copyListProperties(sourceList,RoleListAllRequest.class);
	}

}
