package com.javaweb.web.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.CommonConstant;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.role.RoleIdAndStrategyRequest;
import com.javaweb.web.eo.user.RoleInfoResponse;
import com.javaweb.web.eo.user.UserAddRequest;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.eo.user.UserListResponse;
import com.javaweb.web.eo.user.UserLoginRequest;
import com.javaweb.web.eo.user.UserModifyRequest;
import com.javaweb.web.eo.user.UserModuleAssignmentRequest;
import com.javaweb.web.po.User;
import com.javaweb.web.po.UserModule;
import com.javaweb.web.po.UserRole;
import com.javaweb.web.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl extends BaseDao implements UserService {
	
	@Override
	public User userLogin(UserLoginRequest userLogin) {
		QueryWapper<User> queryWapper = new QueryWapper<>();
		queryWapper.eq(User.userNameColumn,userLogin.getUsername());
		queryWapper.eq(User.passwordColumn,userLogin.getPassword());
		queryWapper.eq(User.delFlagColumn,0);
		return userDao.selectOne(queryWapper);
	}

	@Override
	public Page userList(UserListRequest userListRequest){
		List<UserListResponse> list = userDao.userList(userListRequest);
		long count = userDao.userListCount(userListRequest);
		Page page = new Page(userListRequest,list,count);
		return page;
	}

	@Transactional
	@Override
	public void userDelete(String userId) {
		String userIds[] = userId.split(CommonConstant.COMMA);
		for(String id:userIds){
			User user = userDao.selectByPk(userId);
			if(user!=null){
				if(user.getPortrait()!=null){
					new File(user.getPortrait()).delete();//文件不存在也不会报错的
				}
				userDao.userDelete(id);
			}
		}
	}
	
	@Transactional
	@Override
	public void userAdd(User user) {
		userDao.insert(user);
	}
	
	@Transactional
	@Override
	public void userAdd(User currentUser,UserAddRequest userAddRequest) {
		User user = new User();
		ObjectOperateUtil.copyProperties(userAddRequest,user);
		try{
			user.setPassword(SecretUtil.getSecret(user.getPassword(),"SHA-256"));
		}catch(Exception e){
			user.setPassword("e9cee71ab932fde863338d08be4de9dfe39ea049bdafb342ce659ec5450b69ae");//abcd1234
		}
		user.setParentId(currentUser.getUserId());
		user.setLevel(currentUser.getLevel()+1);//数字越大用户级别越低，这里默认新创建的用户都比创建它的用户低一级（数字是加1）
		user.setCreator(currentUser.getUserId());
		user.setCreateDate(new Date());
		userDao.insert(user);
	}

	@Transactional
	@Override
	public void userModify(User user) {
		userDao.update(user);
	}
	
	@Transactional
	@Override
	public void userModify(User currentUser,UserModifyRequest userModifyRequest) {
		User user = new User();
		ObjectOperateUtil.copyProperties(userModifyRequest,user);
		user.setPassword(null);//密码不在此处修改
		user.setUpdater(currentUser.getUserId());
		user.setUpdateDate(new Date());
		userDao.update(user);
	}

	@Override
	public User userDetail(String userId) {
		QueryWapper<User> queryWapper = new QueryWapper<>();
		queryWapper.eq(User.userIdColumn,userId);
		queryWapper.eq(User.delFlagColumn,0);
		return userDao.selectOne(queryWapper);
	}
	
	@Override
	public List<User> getUsersByUserId(List<String> list) {
		return userDao.getUsersByUserId(list);
	}

	@Override
	public List<RoleInfoResponse> userRoleInfo(String userId) {
		return userDao.userRoleInfo(userId);
	}
	
	@Transactional
	@Override
	public void userRoleAssignment(String userId,List<RoleIdAndStrategyRequest> list) {
		Map<String,Object> map = new HashMap<>();
		List<UserRole> userRoleList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			UserRole userRole = new UserRole();
			userRole.setId(idGenerator.idCreate());
			userRole.setUserId(userId);
			userRole.setRoleId(list.get(i).getRoleId());
			Integer moduleStrategy = list.get(i).getModuleStrategy();
			Integer dataStrategy = list.get(i).getDataStrategy();
			userRole.setModuleStrategy(moduleStrategy==null?0:moduleStrategy);
			userRole.setDataStrategy(dataStrategy==null?0:dataStrategy);
			userRoleList.add(userRole);
		}
		map.put("userId",userId);
		map.put("list",userRoleList);
		userDao.userRoleAssignment(map);
	}
	
	@Override
	public List<ModuleInfoResponse> userModuleInfo(String userId) {
		List<ModuleInfoResponse> list = userDao.userModuleInfo(userId);
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
	public void userModuleAssignment(UserModuleAssignmentRequest userModuleAssignmentRequest) {
		String userId = userModuleAssignmentRequest.getUserId();
		List<String> list = userModuleAssignmentRequest.getList();
		Map<String,Object> map = new HashMap<>();
		List<UserModule> userModuleList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			UserModule userModule = new UserModule();
			userModule.setId(idGenerator.idCreate());
			userModule.setUserId(userId);
			userModule.setModuleId(list.get(i));
			userModuleList.add(userModule);
		}
		map.put("userId",userId);
		map.put("list",userModuleList);
		userDao.userModuleAssignment(map);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.selectAll();
	}

	@Transactional
	@Override
	public void userInitPassword(String userId,TokenData tokenData) {
		String initPassword = BaseSystemMemory.getConfigValueByKey("init.user.password","abcd1234");
		try{
			initPassword = SecretUtil.getSecret(initPassword,"SHA-256");
		}catch(Exception e){ 
			//do nothing
		}
		User user = new User();
		user.setUserId(userId);
		user.setPassword(initPassword);
		user.setStatus(null);//只是初始化密码，并不改变原来账号的状态
		user.setUpdater(tokenData.getUser().getUserId());
		user.setUpdateDate(new Date());
		userDao.update(user);
	}

	/**
	@Transactional
	@Override
	public void userPortraitUpload(String userId,MultipartFile multipartFile) {
		String uploadMultipartFileName = multipartFile.getOriginalFilename();//得到上传文件的文件名称
		String uploadFileTypes[] = uploadMultipartFileName.split("\\.");
		String uploadFileName = userId+CommonConstant.DOT+uploadFileTypes[uploadFileTypes.length-1];
		String rootPath = BaseTool.getFileUploadPath();
		FileUtil.makeFolder(new File(rootPath));
		boolean writeSuccess = true;
		try{
			FileUtil.writeFile(multipartFile.getInputStream(),new byte[1024],new File(rootPath+uploadFileName));
		}catch(IOException e){
			writeSuccess = false;
		}
		if(writeSuccess){
			User user = userDao.selectByPk(userId);
			if(user!=null){
				String portrait = user.getPortrait();
				if((portrait!=null)&&(!CommonConstant.EMPTY_VALUE.equals(portrait))){
					new File(portrait).delete();//文件不存在也不会报错的
				}
				user.setPortrait(rootPath+uploadFileName);
				userDao.update(user);
			}
		}
	}
	
	@Override
	public void userPortrait(String userId,HttpServletResponse httpServletResponse) {
		if(userId!=null){
			User user = userDao.selectByPk(userId);
			if(user!=null){
				String portrait = user.getPortrait();
				if(portrait!=null){
					File file = new File(portrait);
					if(file.exists()){
						try {
							FileUtil.downloadFile(httpServletResponse.getOutputStream(),new byte[1024],file);
						} catch (IOException e) {
							//do nothing
						}
					}
				}
			}
		}
	}
	*/

}
