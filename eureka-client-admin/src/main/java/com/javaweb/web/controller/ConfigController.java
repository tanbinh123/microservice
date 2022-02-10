package com.javaweb.web.controller;

import java.util.Date;

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
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.config.ConfigListRequest;
import com.javaweb.web.po.Config;
import com.javaweb.web.po.User;

//登录且需要权限才可访问的配置管理模块
@RestController
@RequestMapping(ApiConstant.WEB_CONFIG_PREFIX)
public class ConfigController extends BaseService {
    
	@PostMapping(ApiConstant.CONFIG_ADD)
	@ControllerMethod(interfaceName="新增配置接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult configAdd(@RequestBody Config config,@TokenDataAnnotation TokenData tokenData){
		User currentUser = tokenData.getUser();
		config.setId(idGenerator.idCreate());
		config.setSort(CommonConstant.ZERO_STRING_VALUE);
		config.setUniversally(0);
		config.setCreator(currentUser.getUserId());
		config.setCreateDate(new Date());
		configService.configAdd(config);
		stringRedisTemplate.convertAndSend(SystemConstant.CONFIG_TOPIC,SystemConstant.CONFIG_TOPIC);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"config.add.success",null);
	}
	
	@PostMapping(ApiConstant.CONFIG_LIST)
	@ControllerMethod(interfaceName="查询配置接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult configList(@RequestBody ConfigListRequest configListRequest){
		Page page = configService.configList(configListRequest);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"config.list.success",page);
	}
	
	@PutMapping(ApiConstant.CONFIG_MODIFY)
	@ControllerMethod(interfaceName="修改配置接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult configModify(@RequestBody Config config,@TokenDataAnnotation TokenData tokenData){
		User currentUser = tokenData.getUser();
		config.setUpdater(currentUser.getUserId());
		config.setUpdateDate(new Date());
		configService.configModify(config);
		stringRedisTemplate.convertAndSend(SystemConstant.CONFIG_TOPIC,SystemConstant.CONFIG_TOPIC);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"config.modify.success",null);
	}
	
	@GetMapping(ApiConstant.CONFIG_DETAIL)
	@ControllerMethod(interfaceName="配置详情接口",auth=AuthEnum.PERMISSION)
	public BaseResponseResult configDetail(@PathVariable(name="configId",required=true) String configId){
		Config config = configService.configDetail(configId);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"config.detail.success",config);
	}
	
	@DeleteMapping(ApiConstant.CONFIG_DELETE)
	@ControllerMethod(interfaceName="删除配置接口（支持批量删除，用逗号隔开）",auth=AuthEnum.PERMISSION)
	public BaseResponseResult configDelete(@PathVariable(name="configId",required=true) String configId){
		configService.configDelete(configId);
		stringRedisTemplate.convertAndSend(SystemConstant.CONFIG_TOPIC,SystemConstant.CONFIG_TOPIC);
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"config.delete.success",null);
	}
	
}
