package com.javaweb.web.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.javaweb.web.eo.role.RoleAddRequest;
import com.javaweb.web.eo.role.RoleDetailResponse;
import com.javaweb.web.eo.role.RoleListAllRequest;
import com.javaweb.web.eo.role.RoleListRequest;
import com.javaweb.web.eo.role.RoleModifyRequest;
import com.javaweb.web.eo.validate.ColumnsRepeatRequest;
import com.javaweb.web.po.Role;

//登录且需要权限才可访问的角色管理模块
@RestController
@RequestMapping(ApiConstant.WEB_ROLE_PREFIX)
public class RoleController extends BaseService {
	
	@PostMapping(ApiConstant.ROLE_ADD)
	@ControllerMethod(interfaceName="新增角色接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleAdd(@RequestBody RoleAddRequest roleAddRequest,@TokenDataAnnotation TokenData tokenData){
		List<ColumnsRepeatRequest<Role>> columnsRepeatRequestList = new ArrayList<>();
		columnsRepeatRequestList.add(new ColumnsRepeatRequest<Role>(Role.roleNameColumn,roleAddRequest.getRoleName(),"validated.role.roleName.repeat"));
		columnsRepeatRequestList.add(new ColumnsRepeatRequest<Role>(Role.roleCodeColumn,roleAddRequest.getRoleCode(),"validated.role.roleCode.repeat"));
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(columnsRepeatRequestList,roleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		roleService.roleAdd(tokenData.getUser(),roleAddRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.add.success");
	}
	
	@PostMapping(ApiConstant.ROLE_LIST)
	@ControllerMethod(interfaceName="查询角色接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleList(@RequestBody RoleListRequest roleListRequest){
		Page page = roleService.roleList(roleListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.list.success",page);
	}
	
	@PutMapping(ApiConstant.ROLE_MODIFY)
	@ControllerMethod(interfaceName="修改角色接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleModify(@RequestBody RoleModifyRequest roleModifyRequest,@TokenDataAnnotation TokenData tokenData){
		Role originRole = roleService.roleDetail(roleModifyRequest.getRoleId());
		if(originRole==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.role.modify.notExist");
		}
		ColumnsRepeatRequest<Role> roleColumnsRepeatRequest = new ColumnsRepeatRequest<Role>(Role.roleIdColumn,originRole.getRoleId(),Role.roleNameColumn,roleModifyRequest.getRoleName(),"validated.role.roleName.repeat");
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(roleColumnsRepeatRequest,roleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		roleColumnsRepeatRequest = new ColumnsRepeatRequest<Role>(Role.roleIdColumn,originRole.getRoleId(),Role.roleCodeColumn,roleModifyRequest.getRoleCode(),"validated.role.roleCode.repeat");
		baseServiceValidateResult = validateService.isColumnsValueRepeat(roleColumnsRepeatRequest,roleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		roleService.roleModify(tokenData.getUser(),roleModifyRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.modify.success");
	}
	
	@GetMapping(ApiConstant.ROLE_DETAIL)
	@ControllerMethod(interfaceName="角色详情接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleDetail(@PathVariable(name="roleId",required=true) String roleId){
		Role role = roleService.roleDetail(roleId);
		if(role==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.role.notExist");
		}
		RoleDetailResponse roleDetailResponse = new RoleDetailResponse();
		ObjectOperateUtil.copyProperties(role,roleDetailResponse);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.detail.success",roleDetailResponse);
	}
	
	@DeleteMapping(ApiConstant.ROLE_DELETE)
	@ControllerMethod(interfaceName="删除角色接口（支持批量删除，用逗号隔开）",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleDelete(@PathVariable(name="roleId",required=true) String roleId){
		roleService.roleDelete(roleId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.delete.success");
	}
	
	@GetMapping(ApiConstant.ROLE_MODULE_INFO)
	@ControllerMethod(interfaceName="角色模块信息接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleModuleInfo(@PathVariable(name="roleId",required=true) String roleId){
		List<ModuleInfoResponse> list = roleService.roleModuleInfo(roleId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.roleModuleInfo.success",list);
	}
	
	@PostMapping(ApiConstant.ROLE_MODULE_ASSIGNMENT)
	@ControllerMethod(interfaceName="角色模块分配接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleModuleAssignment(@RequestBody List<String> list,@PathVariable(name="roleId",required=true) String roleId){
		roleService.roleModuleAssignment(roleId,list);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.roleModuleAssignment.success");
	}
	
	@GetMapping(ApiConstant.ROLE_LIST_ALL)
	@ControllerMethod(interfaceName="角色列表接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleListAll(){
		List<RoleListAllRequest> list = roleService.roleListAll();
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"role.roleListAll.success",list);
	}
	
}
