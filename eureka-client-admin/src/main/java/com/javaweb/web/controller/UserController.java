package com.javaweb.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.annotation.token.TokenDataAnnotation;
import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseService;
import com.javaweb.base.BaseServiceValidateResult;
import com.javaweb.constant.ApiConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.role.ModuleInfoResponse;
import com.javaweb.web.eo.role.RoleIdAndStrategyRequest;
import com.javaweb.web.eo.user.RoleInfoResponse;
import com.javaweb.web.eo.user.UserAddRequest;
import com.javaweb.web.eo.user.UserDetailResponse;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.eo.user.UserListResponse;
import com.javaweb.web.eo.user.UserModifyRequest;
import com.javaweb.web.eo.user.UserModuleAssignmentRequest;
import com.javaweb.web.eo.validate.ColumnsRepeatRequest;
import com.javaweb.web.po.User;

//登录且需要权限才可访问的用户管理模块
@RestController
@RequestMapping(ApiConstant.WEB_USER_PREFIX)
public class UserController extends BaseService {

	@PostMapping(ApiConstant.USER_ADD)
	@ControllerMethod(interfaceName="新增用户接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userAdd(@RequestBody @Validated UserAddRequest userAddRequest,@TokenDataAnnotation TokenData tokenData,HttpServletRequest request){
		ColumnsRepeatRequest<User> userColumnsRepeatRequest = new ColumnsRepeatRequest<User>(User.userNameColumn,userAddRequest.getUserName(),"validated.user.userName.repeat");
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(userColumnsRepeatRequest,userDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		userService.userAdd(tokenData.getUser(),userAddRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.add.success");
	}
	
	@PostMapping(ApiConstant.USER_LIST)
	@ControllerMethod(interfaceName="查询用户接口",auth=AuthEnum.PERMISSION,dataPermissionEntity=UserListResponse.class)
	public BaseResponseResult userList(@RequestBody UserListRequest userListRequest,@TokenDataAnnotation TokenData tokenData){
		Page page = userService.userList(userListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.list.success",page);
	}
	
	@PutMapping(ApiConstant.USER_MODIFY)
	@ControllerMethod(interfaceName="修改用户接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userModify(@RequestBody @Validated UserModifyRequest userModifyRequest,@TokenDataAnnotation TokenData tokenData,HttpServletRequest request){
		User originUser = userService.userDetail(userModifyRequest.getUserId());
		if(originUser==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.user.modify.notExist");
		}
		ColumnsRepeatRequest<User> userColumnsRepeatRequest = new ColumnsRepeatRequest<User>(User.userIdColumn,originUser.getUserId(),User.userNameColumn,userModifyRequest.getUserName(),"validated.user.userName.repeat");
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(userColumnsRepeatRequest,userDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		userService.userModify(tokenData.getUser(),userModifyRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.modify.success");
	}
	
	@GetMapping(ApiConstant.USER_DETAIL)
	@ControllerMethod(interfaceName="用户详情接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userDetail(@PathVariable(name="userId",required=true) String userId){
		User user = userService.userDetail(userId);
		if(user==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.user.notExist");
		}
		user.setPassword(null);
		UserDetailResponse userDetailResponse = new UserDetailResponse();
		ObjectOperateUtil.copyProperties(user,userDetailResponse);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.detail.success",userDetailResponse);
	}
	
	@DeleteMapping(ApiConstant.USER_DELETE)
	@ControllerMethod(interfaceName="删除用户接口（支持批量删除，用逗号隔开）",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userDelete(@PathVariable(name="userId",required=true) String userId){
		userService.userDelete(userId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.delete.success");
	}
	
	@GetMapping(ApiConstant.USER_ROLE_INFO)
	@ControllerMethod(interfaceName="用户角色信息接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userRoleInfo(@PathVariable(name="userId",required=true) String userId){
		List<RoleInfoResponse> list = userService.userRoleInfo(userId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.userRoleInfo.success",list);
	}

	@PostMapping(ApiConstant.USER_ROLE_ASSIGNMENT)
	@ControllerMethod(interfaceName="用户角色分配接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userRoleAssignment(@RequestBody List<RoleIdAndStrategyRequest> list,@PathVariable(name="userId",required=true) String userId){
		userService.userRoleAssignment(userId,list);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.userRoleAssignment.success");
	}
	
	@GetMapping(ApiConstant.USER_MODULE_INFO)
	@ControllerMethod(interfaceName="用户模块信息接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userModuleInfo(@PathVariable(name="userId",required=true) String userId){
		List<ModuleInfoResponse> list = userService.userModuleInfo(userId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.userModuleInfo.success",list);
	}
	
	@PostMapping(ApiConstant.USER_MODULE_ASSIGNMENT)
	@ControllerMethod(interfaceName="用户模块分配接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userModuleAssignment(@RequestBody UserModuleAssignmentRequest userModuleAssignmentRequest){
		userService.userModuleAssignment(userModuleAssignmentRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.userModuleAssignment.success");
	}
	
	@GetMapping(ApiConstant.USER_INIT_PASSWORD)
	@ControllerMethod(interfaceName="初始化密码接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userInitPassword(@PathVariable(name="userId",required=true) String userId,@TokenDataAnnotation TokenData tokenData){
		userService.userInitPassword(userId,tokenData);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.init.password.success");
	}
	
	/**
	@PostMapping(ApiConstant.USER_PORTRAIT_UPLOAD)
	@ControllerMethod(interfaceName="用户头像上传接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult userPortraitUpload(@TokenDataAnnotation TokenData tokenData,@PathVariable(name="userId",required=true) String userId,@RequestParam(value="userPortraitFile") MultipartFile multipartFile){
		userService.userPortraitUpload(userId,multipartFile);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"user.portrait.upload.success");
	}
	
	@GetMapping(ApiConstant.USER_USER_PORTRAIT)
	@ControllerMethod(interfaceName="获取用户头像接口",auth=AuthEnum.PERMISSION)
	public void userPortrait(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		userService.userPortrait(httpServletRequest.getParameter(SystemConstant.HEAD_USERID),httpServletResponse);
	}
	*/
	
}
