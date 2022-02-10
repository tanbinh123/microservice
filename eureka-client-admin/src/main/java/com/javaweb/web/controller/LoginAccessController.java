package com.javaweb.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.annotation.token.TokenDataAnnotation;
import com.javaweb.annotation.url.ControllerMethod;
import com.javaweb.base.BaseInject;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseService;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.ApiConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.interfaces.InterfaceInfoResponse;
import com.javaweb.web.po.Dictionary;
import com.javaweb.web.po.Interfaces;

//登录才可访问的模块
@RestController
@RequestMapping(ApiConstant.WEB_LOGIN_ACCESS_PREFIX)
public class LoginAccessController extends BaseService {
	
	@GetMapping(ApiConstant.LOGIN_OUT)
	@ControllerMethod(interfaceName="用户登出接口",auth=AuthEnum.LOGIN)
	public BaseResponseResult logout(@TokenDataAnnotation TokenData tokenData){
		if(deleteFromRedisByKey(BaseInject.getRedisTokenKey(tokenData))) {
			return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.logoutSuccess");
		}else {
			return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.logoutFail");
		}
	}
	
	@GetMapping(ApiConstant.GET_REDIS_TOKEN_DATA)
	@ControllerMethod(interfaceName="获取redis中的token信息接口",auth=AuthEnum.LOGIN)
	public BaseResponseResult getRedisTokenData(@TokenDataAnnotation TokenData tokenData){
		tokenData.setRsaPrivateKey1(null);
		tokenData.setRsaPublicKey2(null);
		List<String> apiUrlList = tokenData.getApiUrlList();
		if(apiUrlList!=null&&apiUrlList.size()>0){
			List<Interfaces> interfacesList = BaseSystemMemory.interfacesList;
			List<InterfaceInfoResponse> interfaceInfoResponseList = new ArrayList<>();
			for(int i=0;i<apiUrlList.size();i++){
				for(int j=0;j<interfacesList.size();j++){
					Interfaces interfaces = interfacesList.get(j);
					if(apiUrlList.get(i).equals(interfaces.getUrl())){
						interfaceInfoResponseList.add(new InterfaceInfoResponse(interfaces.getUrl(),interfaces.getRequestDataSecret(),interfaces.getResponseDataSecret()));
						break;
					}
				}
			}
			tokenData.setInterfaceInfoResponseList(interfaceInfoResponseList);
		}
		return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.getTokenDataSuccess",tokenData);
	}
	
    @PostMapping(ApiConstant.GET_DICTIONARY)
    @ControllerMethod(interfaceName="获得字典信息接口",auth=AuthEnum.LOGIN)
    public BaseResponseResult getDictionary(@RequestBody Dictionary dictionary) {
	    return getBaseResponseResult(HttpCodeEnum.SUCCESS,"login.user.getDictionarySuccess",dictionaryService.getDictionary(dictionary));
	}
    
}
