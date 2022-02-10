package com.javaweb.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.annotation.token.TokenDataAnnotation;
import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseService;
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.StringUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.roleRestrict.RoleRestrictAddRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictModifyRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictResponse;
import com.javaweb.web.po.RoleRestrict;

import net.sf.json.JSONObject;

//登录且需要权限才可访问的角色限定管理模块
@RestController
@RequestMapping(ApiConstant.WEB_ROLE_RESTRICT_PREFIX)
public class RoleRestrictController extends BaseService {
	
	private final Logger LOG = LoggerFactory.getLogger(LoginAccessController.class);

	@PostMapping(ApiConstant.ROLE_RESTRICT_ADD)
	@ControllerMethod(interfaceName="新增角色限定接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleRestrictAdd(@RequestBody @Validated RoleRestrictAddRequest roleRestrictAddRequest,@TokenDataAnnotation TokenData tokenData){
		if(roleRestrictAddRequest.getRestrictWay()==1){
			roleRestrictAddRequest.setProvince(SystemConstant.SELF);
			roleRestrictAddRequest.setCity(SystemConstant.SELF);
			roleRestrictAddRequest.setDistrict(SystemConstant.SELF);
		}else{
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictAddRequest.getProvince()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.notEmpty");
			}
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictAddRequest.getCity()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.notEmpty");
			}
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictAddRequest.getDistrict()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.district.notEmpty");
			}
			if((!SystemConstant.SELF.equals(roleRestrictAddRequest.getProvince()))&&(!SystemConstant.ALL.equals(roleRestrictAddRequest.getProvince()))){
				if(!provinceService.isExistBySelectProvinceCode(roleRestrictAddRequest.getProvince())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.notExist");
				}
			}
			if((!SystemConstant.SELF.equals(roleRestrictAddRequest.getCity()))&&(!SystemConstant.ALL.equals(roleRestrictAddRequest.getCity()))){
				if(!cityService.isExistBySelectProvinceAndCityCode(roleRestrictAddRequest.getProvince(),roleRestrictAddRequest.getCity())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.notExist");
				}
			}
			if((!SystemConstant.SELF.equals(roleRestrictAddRequest.getDistrict()))&&(!SystemConstant.ALL.equals(roleRestrictAddRequest.getDistrict()))){
				if(!districtService.isExistBySelectCityAndDistrictCode(roleRestrictAddRequest.getCity(),roleRestrictAddRequest.getDistrict())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.district.notExist");
				}
			}
		    //选择了self，下面只能是self或all，因为如果省是self，市来个苏州市，最后self转为浙江省，那么这个限定其实没什么意义了
	        if(roleRestrictAddRequest.getProvince().equals(SystemConstant.SELF)){
	            if(!(roleRestrictAddRequest.getCity().equals(SystemConstant.SELF)||roleRestrictAddRequest.getCity().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.self.limit");
	            }
	        }
	        if(roleRestrictAddRequest.getCity().equals(SystemConstant.SELF)){
	            if(!(roleRestrictAddRequest.getDistrict().equals(SystemConstant.SELF)||roleRestrictAddRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.self.limit");
	            }
	        }
	        //选择了all，下面只能是all
	        if(roleRestrictAddRequest.getProvince().equals(SystemConstant.ALL)){
	            if(!(roleRestrictAddRequest.getCity().equals(SystemConstant.ALL)&&roleRestrictAddRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.all.limit");
	            }
	        }
	        if(roleRestrictAddRequest.getCity().equals(SystemConstant.ALL)){
	            if(!(roleRestrictAddRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.all.limit");
	            }
	        } 
	        //判断角色限定是否存在交集
	        if(roleRestrictService.roleRestrictIntersect(roleRestrictAddRequest.getProvince(),roleRestrictAddRequest.getCity(),roleRestrictAddRequest.getDistrict(),roleRestrictAddRequest.getRoleId(),roleRestrictAddRequest.getRestrictWay())){
	        	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.intersect.limit");
	        }
		}
		roleRestrictService.roleRestrictAdd(roleRestrictAddRequest,tokenData.getUser());
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"roleRestrict.add.success");
	}
	
	@PostMapping(ApiConstant.ROLE_RESTRICT_MODIFY)
	@ControllerMethod(interfaceName="修改角色限定接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleRestrictModify(@RequestBody @Validated RoleRestrictModifyRequest roleRestrictModifyRequest,@TokenDataAnnotation TokenData tokenData){
		RoleRestrict originRoleRestrict = roleRestrictService.roleRestrictDetail(roleRestrictModifyRequest.getId());
		if(originRoleRestrict==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.notExist");
		}
		if(roleRestrictModifyRequest.getRestrictWay()==1){
			roleRestrictModifyRequest.setProvince(SystemConstant.SELF);
			roleRestrictModifyRequest.setCity(SystemConstant.SELF);
			roleRestrictModifyRequest.setDistrict(SystemConstant.SELF);
		}
		if((roleRestrictModifyRequest.getRoleId().equals(originRoleRestrict.getRoleId()))&&
		   (roleRestrictModifyRequest.getProvince().equals(originRoleRestrict.getProvince()))&&
		   (roleRestrictModifyRequest.getCity().equals(originRoleRestrict.getCity()))&&
		   (roleRestrictModifyRequest.getDistrict().equals(originRoleRestrict.getDistrict()))&&
		   (roleRestrictModifyRequest.getRestrictWay().equals(originRoleRestrict.getRestrictWay()))){
			//do nothing
		}else{
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictModifyRequest.getProvince()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.notEmpty");
			}
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictModifyRequest.getCity()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.notEmpty");
			}
			if(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(roleRestrictModifyRequest.getDistrict()))){
				return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.district.notEmpty");
			}
			if((!SystemConstant.SELF.equals(roleRestrictModifyRequest.getProvince()))&&(!SystemConstant.ALL.equals(roleRestrictModifyRequest.getProvince()))){
				if(!provinceService.isExistBySelectProvinceCode(roleRestrictModifyRequest.getProvince())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.notExist");
				}
			}
			if((!SystemConstant.SELF.equals(roleRestrictModifyRequest.getCity()))&&(!SystemConstant.ALL.equals(roleRestrictModifyRequest.getCity()))){
				if(!cityService.isExistBySelectProvinceAndCityCode(roleRestrictModifyRequest.getProvince(),roleRestrictModifyRequest.getCity())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.notExist");
				}
			}
			if((!SystemConstant.SELF.equals(roleRestrictModifyRequest.getDistrict()))&&(!SystemConstant.ALL.equals(roleRestrictModifyRequest.getDistrict()))){
				if(!districtService.isExistBySelectCityAndDistrictCode(roleRestrictModifyRequest.getCity(),roleRestrictModifyRequest.getDistrict())){
					return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.district.notExist");
				}
			}
		    //选择了self，下面只能是self或all，因为如果省是self，市来个苏州市，最后self转为浙江省，那么这个限定其实没什么意义了
	        if(roleRestrictModifyRequest.getProvince().equals(SystemConstant.SELF)){
	            if(!(roleRestrictModifyRequest.getCity().equals(SystemConstant.SELF)||roleRestrictModifyRequest.getCity().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.self.limit");
	            }
	        }
	        if(roleRestrictModifyRequest.getCity().equals(SystemConstant.SELF)){
	            if(!(roleRestrictModifyRequest.getDistrict().equals(SystemConstant.SELF)||roleRestrictModifyRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.self.limit");
	            }
	        }
	        //选择了all，下面只能是all
	        if(roleRestrictModifyRequest.getProvince().equals(SystemConstant.ALL)){
	            if(!(roleRestrictModifyRequest.getCity().equals(SystemConstant.ALL)&&roleRestrictModifyRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.province.all.limit");
	            }
	        }
	        if(roleRestrictModifyRequest.getCity().equals(SystemConstant.ALL)){
	            if(!(roleRestrictModifyRequest.getDistrict().equals(SystemConstant.ALL))){
	            	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.city.all.limit");
	            }
	        } 
	        //判断角色限定是否存在交集
	        if(roleRestrictService.roleRestrictIntersect(roleRestrictModifyRequest.getProvince(),roleRestrictModifyRequest.getCity(),roleRestrictModifyRequest.getDistrict(),roleRestrictModifyRequest.getRoleId(),roleRestrictModifyRequest.getRestrictWay())){
	        	return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.intersect.limit");
	        }
		}
		roleRestrictService.roleRestrictModify(roleRestrictModifyRequest,tokenData.getUser());
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"roleRestrict.modify.success");
	}
	
	@GetMapping(ApiConstant.ROLE_RESTRICT_DETAIL)
	@ControllerMethod(interfaceName="角色限定详情接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleRestrictDetail(@PathVariable(name="roleRestrictId",required=true) String roleRestrictId){
		RoleRestrict originRoleRestrict = roleRestrictService.roleRestrictDetail(roleRestrictId);
		if(originRoleRestrict==null){
			return getBaseResponseResult(HttpCodeEnum.VALIDATE_ERROR,"validated.roleRestrict.notExist");
		}
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"roleRestrict.detail.success",originRoleRestrict);
	}
	
	@DeleteMapping(ApiConstant.ROLE_RESTRICT_DELETE)
	@ControllerMethod(interfaceName="删除角色限定接口（支持批量删除，用逗号隔开）",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleRestrictDelete(@PathVariable(name="roleRestrictId",required=true) String roleRestrictId){
		roleRestrictService.roleRestrictDelete(roleRestrictId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"roleRestrict.delete.success");
	}
	
	@PostMapping(ApiConstant.ROLE_RESTRICT_LIST)
	@ControllerMethod(interfaceName="查询角色限定接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult roleRestrictList(@RequestBody RoleRestrictListRequest roleRestrictListRequest,@TokenDataAnnotation TokenData tokenData){
		Page page = roleRestrictService.roleRestrictList(roleRestrictListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"roleRestrict.list.success",page);
	}
	
    @GetMapping(ApiConstant.ROLE_RESTRICT_PROVINCE)
    @ControllerMethod(interfaceName="获得省信息接口（角色限定）",auth=AuthEnum.PERMISSION)
    public BaseResponseResult getProvinceRoleRestrict(@TokenDataAnnotation TokenData tokenData,HttpServletRequest httpServletRequest) {
    	RoleRestrictResponse roleRestrictResponse = roleRestrictService.roleRestrict(tokenData.getUser(),tokenData.getAlias(),tokenData.getBestMatchingPattern());
	    LOG.info("角色限定数据为："+JSONObject.fromObject(roleRestrictResponse).toString());
	    return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.getProvinceSuccess",provinceService.getProvinceList(roleRestrictResponse));
	}
    
    @GetMapping(ApiConstant.ROLE_RESTRICT_CITY)
    @ControllerMethod(interfaceName="获得市信息接口（角色限定）",auth=AuthEnum.PERMISSION)
    public BaseResponseResult getCityRoleRestrict(@PathVariable(name="provinceCode",required=true) String provinceCode,@TokenDataAnnotation TokenData tokenData,HttpServletRequest httpServletRequest) {
    	RoleRestrictResponse roleRestrictResponse = roleRestrictService.roleRestrict(tokenData.getUser(),tokenData.getAlias(),tokenData.getBestMatchingPattern());
	    LOG.info("角色限定数据为："+JSONObject.fromObject(roleRestrictResponse).toString());
    	return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.getCitySuccess",cityService.getCityList(provinceCode,roleRestrictResponse));
	}
    
    @GetMapping(ApiConstant.ROLE_RESTRICT_DISTRICT)
    @ControllerMethod(interfaceName="获得区信息接口（角色限定）",auth=AuthEnum.PERMISSION)
    public BaseResponseResult getDistrictRoleRestrict(@PathVariable(name="cityCode",required=true) String cityCode,@TokenDataAnnotation TokenData tokenData,HttpServletRequest httpServletRequest) {
    	RoleRestrictResponse roleRestrictResponse = roleRestrictService.roleRestrict(tokenData.getUser(),tokenData.getAlias(),tokenData.getBestMatchingPattern());
	    LOG.info("角色限定数据为："+JSONObject.fromObject(roleRestrictResponse).toString());
    	return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.getDistrictSuccess",districtService.getDistrictList(cityCode,roleRestrictResponse));
	}
	
}
