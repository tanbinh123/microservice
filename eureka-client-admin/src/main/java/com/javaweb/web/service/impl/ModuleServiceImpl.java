package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.module.ModuleAddRequest;
import com.javaweb.web.eo.module.ModuleIdAndNameResponse;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleListResponse;
import com.javaweb.web.eo.module.ModuleModifyRequest;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.User;
import com.javaweb.web.po.UserRole;
import com.javaweb.web.service.ModuleService;

@Service("moduleServiceImpl")
public class ModuleServiceImpl extends BaseDao implements ModuleService {
	
	@Override
	public List<Module> getModule(String userId) {
		if(SystemConstant.ADMIN_USER_ID.equals(userId)){//管理员
			return moduleDao.selectAll();
		}else{//非管理员
			/** 处理逻辑
			用户模块 -A
			        -B
			用户角色 -角色X（策略为并集）
			              -A
			              -B
			              -C
			        -角色Y（策略为交集）
			              -A
			              -C
			说明：
			1、用户模块有A、B，用户角色X模块有A、B、C，用户角色Y模块有A、C
			2、角色X（策略为并集）即A、B和A、B、C的并集为A、B、C
			3、角色Y（策略为交集）即A、B和A、C的交集为A
			4、合并2、3位A、B、C
			*/
			List<String> allList = new ArrayList<>(); 
			//获得user_role的所有对应关系
			List<UserRole> userRoleList = userRoleDao.selectList(new QueryWapper<UserRole>().eq(UserRole.userIdColumn,userId));
			//获得用户模块ID列表
			List<String> userModuleList = userModuleDao.getModuleIdsByUserId(userId);
			for(int i=0;i<userRoleList.size();i++){
				List<String> list = null;
				UserRole userRole = userRoleList.get(i);
				List<String> roleModuleList = roleModuleDao.getModuleIdsByRoleId(userRole.getRoleId());//获得角色模块ID列表
				int strategy = userRole.getModuleStrategy();//权限获取策略（0：自定义；1：并集；2：交集；3：以用户权限为准；4：以角色权限为准；其它：默认为未定义，作为并集处理）
				switch(strategy){
					case 0:
						list = Stream.concat(userModuleList.stream(),roleModuleList.stream()).distinct().collect(Collectors.toList());//其它情况暂做并集处理
						break;
					case 1:
						list = Stream.concat(userModuleList.stream(),roleModuleList.stream()).distinct().collect(Collectors.toList());
						break;
					case 2:
						list = userModuleList.stream().filter(item->roleModuleList.contains(item)).distinct().collect(Collectors.toList());
						break;
					case 3:
						list = userModuleList;
						break;
					case 4:
						list = roleModuleList;
						break;
					default:
						list = Stream.concat(userModuleList.stream(),roleModuleList.stream()).distinct().collect(Collectors.toList());//其它情况暂做并集处理
						break;
				}
				allList.addAll(list);//合并多角色
			}
			allList = allList.stream().distinct().collect(Collectors.toList());
			if(allList.size()<=0){
				return SystemConstant.EMPTY_MODULE_LSIT;
			}else{
				return moduleDao.getModuleByModuleId(allList);
			}
		}
	}

	@Override
	public Page moduleList(ModuleListRequest moduleListRequest) {
		List<ModuleListResponse> list = moduleDao.moduleList(moduleListRequest);
		long count = moduleDao.moduleListCount(moduleListRequest);
		Page page = new Page(moduleListRequest,list,count);
		return page;
	}

	@Transactional
	@Override
	public void moduleDelete(String moduleIds[]) {
		for(String id:moduleIds){
			moduleDao.moduleDelete(id);
		}
	}

	@Transactional
	@Override
	public void moduleAdd(User user,ModuleAddRequest moduleAddRequest) {
		Module module = new Module();
		ObjectOperateUtil.copyProperties(moduleAddRequest,module);
		module.setCreateDate(new Date());
		module.setCreator(user.getUserId());
		module.setDelFlag(0);
		if(module.getModuleType()==1){//目录
			module.setApiUrl(null);
			module.setPageUrl(null);
		}else if(module.getModuleType()==2){//菜单
			module.setApiUrl(null);
		}else if(module.getModuleType()==3){//功能
			module.setPageUrl(null);
			int apiUrlLength = module.getApiUrl().split(CommonConstant.COMMA).length;
			String[] apiSignArray = new String[apiUrlLength];
			for(int i=0;i<apiUrlLength;i++){
				apiSignArray[i] = SecretUtil.getRandomUUID(false);
			}
			module.setApiSign(String.join(CommonConstant.COMMA,apiSignArray));
		}
		if(module.getParentId()==null||CommonConstant.EMPTY_VALUE.equals(module.getParentId().trim())){
			module.setParentId(null);
		}
		if(module.getParentId()==null){//表示是顶级目录
			module.setLevel(1);
		}else{
			Module parentModuleInfo = moduleDao.moduleDetail(module.getParentId());
			module.setLevel(parentModuleInfo.getLevel()+1);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("parentId",module.getParentId());
		map.put("level",module.getLevel());
		map.put("moduleType",module.getModuleType());
		Long orders = moduleDao.getOrders(map);
		orders = (orders==null?1:orders+1);
		module.setOrders(orders.intValue());
		module.setSystemId(SystemConstant.SYSTEM_NO);
		moduleDao.insert(module);
	}
	
	@Transactional
	@Override
	public void moduleModify(User user,ModuleModifyRequest moduleModifyRequest) {
		Module module = new Module();
		ObjectOperateUtil.copyProperties(moduleModifyRequest,module);
		module.setLevel(null);
		module.setType(null);
		module.setUpdateDate(new Date());
		module.setUpdater(user.getUserId());
		module.setApiSign(null);
		if(module.getParentId()==null||CommonConstant.EMPTY_VALUE.equals(module.getParentId().trim())){
			module.setParentId(null);
			moduleDao.setModuleParentIdNull(module);//当parentId为null表示设置为根目录，此时需要特殊处理，因为大部分更新操作代码逻辑对null值是不更新数据库数据的
		}
		moduleDao.update(module);
	}

	@Override
	public Module moduleDetail(String moduleId) {
		return moduleDao.moduleDetail(moduleId);
	}

	@Override
    public List<ModuleIdAndNameResponse> getModuleIdAndNameList(String moduleType) {
    	/** 这里约定：
    	1、选择目录（1）需要返回可选的上级模块列表，条件为moduleType=1
        2、选择菜单（2）需要返回可选的上级模块列表，条件为moduleType=1
        3、选择功能（3）需要返回可选的上级模块列表，条件为moduleType=2且pageUrl不为null
        */
        Map<String,String> map = new HashMap<>();
        map.put("moduleType",moduleType);
        return moduleDao.getModuleIdAndNameList(map);
    }

	@Override
	public List<Role> getAllRoleByModuleId(String moduleId) {
		return moduleDao.getAllRoleByModuleId(moduleId);
	}
	
	@Override
	public List<User> getAllUserByModuleId(String moduleId) {
		return moduleDao.getAllUserByModuleId(moduleId);
	}

	@Override
	public List<Module> getModuleByParentId(String parentId) {
		return moduleDao.getModuleByParentId(parentId);
	}

}
