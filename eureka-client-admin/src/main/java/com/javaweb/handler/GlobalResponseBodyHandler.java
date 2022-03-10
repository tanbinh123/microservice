package com.javaweb.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.base.BaseInject;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.AuthEnum;
import com.javaweb.enums.HttpCodeEnum;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.interfaces.ExcludeInfoResponse;
import com.javaweb.web.po.Interfaces;

@RestControllerAdvice(basePackages={SystemConstant.DEFAULT_GLOBAL_RESPONSEBODY_PACKAGE})
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<BaseResponseResult>{
	
	public BaseResponseResult beforeBodyWrite(BaseResponseResult baseResponseResult,MethodParameter methodParameter,MediaType mediaType,Class<? extends HttpMessageConverter<?>> c,ServerHttpRequest serverHttpRequest,ServerHttpResponse serverHttpResponse) {
		//String path = serverHttpRequest.getURI().getPath();
		HttpServletRequest httpServletRequest = ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
		Interfaces interfaces = (Interfaces)httpServletRequest.getAttribute(SystemConstant.REQUEST_URL_CHAIN_ATTRIBUTE_NAME);
		if(interfaces!=null){
			if(interfaces.getAuth().equals(AuthEnum.PERMISSION.name())){//目前带权限的接口会处理数据权限
				try {
					TokenData tokenData = BaseInject.getTokenData(BaseInject.getToken(serverHttpRequest));
					if(tokenData!=null){
						List<ExcludeInfoResponse> excludeInfoResponseList = tokenData.getExcludeInfoResponseList();
						if(excludeInfoResponseList!=null&&excludeInfoResponseList.size()>0){
							for(int i=0;i<excludeInfoResponseList.size();i++){
								ExcludeInfoResponse excludeInfoResponse = excludeInfoResponseList.get(i);
								if(interfaces.getUrl().equals(excludeInfoResponse.getUrl())){
									String out = ObjectOperateUtil.excludeField(baseResponseResult,excludeInfoResponse.getExcludeField().split(CommonConstant.COMMA),false).toString();
									baseResponseResult = new ObjectMapper().readValue(out,BaseResponseResult.class);
									break;
								}
							}
						}
					}
				} catch (Exception e) {
					baseResponseResult = new BaseResponseResult(HttpCodeEnum.INTERNAL_ERROR.getCode(),e.getMessage());
				}
			}
		}
		return baseResponseResult;
	}

	public boolean supports(MethodParameter methodParameter,Class<? extends HttpMessageConverter<?>> c) {
		return true;
	}

}
