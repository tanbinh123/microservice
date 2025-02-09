package com.javaweb.web.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.javaweb.constant.CommonConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.module.ModuleAddRequest;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleModifyRequest;
import com.javaweb.web.eo.validate.ColumnsRepeatRequest;
import com.javaweb.web.po.Interfaces;
import com.javaweb.web.po.Module;

//登录且需要权限才可访问的模块管理模块
@RestController
@RequestMapping(ApiConstant.WEB_MODULE_PREFIX)
public class ModuleController extends BaseService {
    
    @GetMapping(ApiConstant.MODULE_GET_MODULE_ID_AND_NAME_LIST)
    @ControllerMethod(interfaceName="获取模块ID和模块名称列表接口",auth=AuthEnum.PERMISSION)
    public BaseResponseResult getModuleIdAndNameList(@PathVariable(name="moduleType",required=false) String moduleType) {
        return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.getModuleIdAndNameList.success",moduleService.getModuleIdAndNameList(moduleType));
    }
	
    /**
          实践建议：
    1、目录：模块的上级ID可选（那就是子目录）也可不选（那就是根目录），页面URL和API的URL都是不需要的
    2、菜单：模块的上级ID必选（所有目录，即moduleType=1），页面URL需要
    3、功能：模块的上级ID必选（所有菜单，即moduleType=2），API的URL需要
	*/
	@PostMapping(ApiConstant.MODULE_ADD)
	@ControllerMethod(interfaceName="新增模块接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult moduleAdd(@RequestBody @Validated ModuleAddRequest moduleAddRequest,@TokenDataAnnotation TokenData tokenData){
		List<ColumnsRepeatRequest<Module>> columnsRepeatRequestList = new ArrayList<>();
		columnsRepeatRequestList.add(new ColumnsRepeatRequest<Module>(Module.moduleNameColumn,moduleAddRequest.getModuleName(),"validated.module.moduleName.repeat"));
		columnsRepeatRequestList.add(new ColumnsRepeatRequest<Module>(Module.aliasColumn,moduleAddRequest.getAlias(),"validated.module.alias.repeat"));
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(columnsRepeatRequestList,moduleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		if(moduleAddRequest.getModuleType()==3){//功能
			List<Interfaces> interfacesList = interfacesService.getAll();
			String apis[] = moduleAddRequest.getApiUrl().split(CommonConstant.COMMA);
			for(int i=0;i<apis.length;i++){
				int j = i;
				if(interfacesList.stream().filter(e->{
					boolean flag = false;
					String urlArray[] = e.getUrl().split(CommonConstant.COMMA); 
					for(String each:urlArray){
						if(each.equals(apis[j])){
							flag = true;
							break;
						}
					}
					return flag;
				}).count()<1){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"interfaces.notExist.fail");
				}
			}
		}
		moduleService.moduleAdd(tokenData.getUser(),moduleAddRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.add.success");
	}
	
	@PostMapping(ApiConstant.MODULE_LIST)
	@ControllerMethod(interfaceName="查询模块接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult moduleList(@RequestBody ModuleListRequest moduleListRequest){
		Page page = moduleService.moduleList(moduleListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.list.success",page);
	}
	
	/**
	修改的逻辑为：
	1、删除权限的逻辑应该是：当前权限若是目录或菜单且有下级关联时，不能删除
	2、修改权限的逻辑应该是：
    	2.1、不能自己关联自己，即将pid设置为自己
     	2.2、判断是否有下级关联
     	2.3、在有下级关联的情况下（操作（按钮）永远排除在外），升降级判断（即非同级操作）：
        	2.3.1、当前权限若是目录不能向下降级为菜单或操作（按钮）
            2.3.2、当前权限若是菜单既不能向上升级也不能向下降级
	*/
	@PutMapping(ApiConstant.MODULE_MODIFY)
	@ControllerMethod(interfaceName="修改模块接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult moduleModify(@RequestBody @Validated ModuleModifyRequest moduleModifyRequest,@TokenDataAnnotation TokenData tokenData){
		Module originModule = moduleService.moduleDetail(moduleModifyRequest.getModuleId());
		if(originModule==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.module.modify.notExist");
		}
		ColumnsRepeatRequest<Module> moduleColumnsRepeatRequest = new ColumnsRepeatRequest<Module>(Module.moduleIdColumn,originModule.getModuleId(),Module.moduleNameColumn,moduleModifyRequest.getModuleName(),"validated.module.moduleName.repeat");
		BaseServiceValidateResult baseServiceValidateResult = validateService.isColumnsValueRepeat(moduleColumnsRepeatRequest,moduleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		moduleColumnsRepeatRequest = new ColumnsRepeatRequest<Module>(Module.moduleIdColumn,originModule.getModuleId(),Module.aliasColumn,moduleModifyRequest.getAlias(),"validated.module.alias.repeat");
		baseServiceValidateResult = validateService.isColumnsValueRepeat(moduleColumnsRepeatRequest,moduleDao);
		if(!baseServiceValidateResult.isValidatePass()){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,baseServiceValidateResult.getMessage());
		}
		if(originModule.getModuleId().equals(moduleModifyRequest.getParentId())){//不能自己关联自己
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"module.modify.fail");
		}
		List<Module> moduleList = moduleService.getModuleByParentId(moduleModifyRequest.getModuleId());
		if(moduleList!=null&&moduleList.size()>0){//判断是否有下级关联
			if(originModule.getModuleType()!=moduleModifyRequest.getModuleType()){//判断是否是同级操作
				if(originModule.getModuleType()<moduleModifyRequest.getModuleType()){//判断是否是降级操作
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"module.modify.fail");
				}else{
					if(originModule.getModuleType()!=1){//若是升级操作，只能原来是目录的升目录
						return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"module.modify.fail");
					}
				}
			}
		}
		if(moduleModifyRequest.getModuleType()==3){//功能
			List<Interfaces> interfacesList = interfacesService.getAll();
			String apis[] = moduleModifyRequest.getApiUrl().split(CommonConstant.COMMA);
			for(int i=0;i<apis.length;i++){
				int j = i;
				if(interfacesList.stream().filter(e->{
					boolean flag = false;
					String urlArray[] = e.getUrl().split(CommonConstant.COMMA); 
					for(String each:urlArray){
						if(each.equals(apis[j])){
							flag = true;
							break;
						}
					}
					return flag;
				}).count()<1){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"interfaces.notExist.fail");
				}
			}
		}
		moduleService.moduleModify(tokenData.getUser(),moduleModifyRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.modify.success");
	}
	
	@GetMapping(ApiConstant.MODULE_DETAIL)
	@ControllerMethod(interfaceName="模块详情接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult moduleDetail(@PathVariable(name="moduleId",required=true) String moduleId){
		Module module = moduleService.moduleDetail(moduleId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.detail.success",module);
	}
	
	@DeleteMapping(ApiConstant.MODULE_DELETE)
	@ControllerMethod(interfaceName="删除模块接口（支持批量删除，用逗号隔开）",auth=AuthEnum.PERMISSION)
	public BaseResponseResult moduleDelete(@PathVariable(name="moduleId",required=true) String moduleId){
		String moduleIds[] = moduleId.split(CommonConstant.COMMA);
		for(String eachModuleId:moduleIds){
			//删除权限，只需要判断当前权限有没有下级关联，没有即可删除
			Module module = moduleService.moduleDetail(eachModuleId);
			if(module.getModuleType()!=3){//非功能需要进一步判断才能确定是否可以删除
				List<Module> moduleList = moduleService.getModuleByParentId(module.getModuleId());
				if(moduleList!=null&&moduleList.size()>0){//当删除目录或菜单时，若有下级关联，则不允许删除
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"module.delete.fail");
				}
			}
		}
		moduleService.moduleDelete(moduleIds);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"module.delete.success");
	}
	
}
