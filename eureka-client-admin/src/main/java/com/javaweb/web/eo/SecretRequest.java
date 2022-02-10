package com.javaweb.web.eo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.core.AesDesUtil;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.core.RsaUtil;
import com.javaweb.util.core.SecretUtil;

//@Getter
//@Setter
public class SecretRequest {
	
	private final Logger logger = LoggerFactory.getLogger(SecretRequest.class);

	private String code;
	
	private String sign;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public boolean rsaCheckPass(HttpServletRequest request,TokenData tokenData){
		String token = request.getHeader("token");//token
		String time = request.getHeader("time");//格式为yyyyMMddHHmmss
		String nonce = request.getHeader("nonce");//长度为24位的随机小写字母和数字的组合
		String thatCode = request.getHeader("code");//post和put的不是放在header里的
		String thatSign = request.getHeader("sign");//post和put的不是放在header里的
		String requestContentType = request.getHeader("requestContentType");//1（application/json）；2（multipart/form-data）；3（application/x-www-form-urlencoded）
		if((!"1".equals(requestContentType))&&(!"2".equals(requestContentType))&&(!"3".equals(requestContentType))){
			return false;
		}
		try{
			if(!(token.equals(tokenData.getToken()))){
				return false;
			}
			Duration duration = DateUtil.getDuration(DateUtil.getDateTime(time,DateUtil.DATETIME_PATTERN_TYPE1),LocalDateTime.now());//日期校验
			if(duration.getSeconds()>60*3){//客户端时间与本地时间间隔（算上各种延迟）不应该超过180秒（3分钟）
				return false;
			}
			nonce = RsaUtil.decrypt(nonce,RsaUtil.getPrivateKey(tokenData.getRsaPrivateKey1()));
			if(nonce.length()!=24){//随机数长度判断
				return false;
			}
			if("GET".equals(request.getMethod().toUpperCase())||"DELETE".equals(request.getMethod().toUpperCase())){
				if(thatCode==null||CommonConstant.EMPTY_VALUE.equals(thatCode.trim())){
					return false;
				}
				if(thatSign==null||CommonConstant.EMPTY_VALUE.equals(thatSign.trim())){
					return false;
				}
				this.code = thatCode;
				this.sign = thatSign;
			}
			return codeSignCheck(tokenData,time,nonce);
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean codeSignCheck(TokenData tokenData,String currentTime,String nonce) throws Exception {
		//1.用后端私钥解密code
		//String d1 = RsaUtil.decrypt(this.code,RsaUtil.getPrivateKey(tokenData.getRsaPrivateKeyOfBackend()));
		//RSA结合AES（推荐），原因参考：https://ask.csdn.net/questions/763621和https://github.com/travist/jsencrypt/issues/137
		//1.用AES解密code
		String d1 = AesDesUtil.decryptAes(this.code,nonce);
		//2.用前端公钥验签
		boolean pass = RsaUtil.verify(SecretUtil.getSecret(currentTime+","+nonce+","+d1,"MD5"),RsaUtil.getPublicKey(tokenData.getRsaPublicKey2()),this.sign);
		if(pass){
			this.code = d1;
			return true;
		}else{
			return false;
		}
	}
	
	public <T> List<T> getEntityForGetDeleteForList(Class<T> c){
		logger.info("Get请求（List）解密后接收到的header参数为："+this.code);
		try {
			//System.out.println(this.code);
			//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			JavaType javaType = new ObjectMapper().getTypeFactory().constructParametricType(ArrayList.class,c);
			return new ObjectMapper().readValue(this.code,javaType);
			//return com.alibaba.fastjson.JSONObject.parseArray(this.code,cls);
		} catch (Exception e) {
			return null;
		} 
	}
	
	public <T> T getEntityForGetDeleteForObject(Class<T> c){
		logger.info("Get请求（Object）解密后接收到的header参数为："+this.code);
		try {
			return new ObjectMapper().readValue(this.code,c);
		} catch (Exception e) {
			return null;
		} 
	}
	
	public <T> List<T> getEntityForPostPutForList(Class<T> c){
		logger.info("Post或Put请求（List）解密后接收到的body参数为："+this.code);
		try {
			//System.out.println(this.code);
			//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			JavaType javaType = new ObjectMapper().getTypeFactory().constructParametricType(ArrayList.class,c);
			return new ObjectMapper().readValue(this.code,javaType);
			//return com.alibaba.fastjson.JSONObject.parseArray(this.code,cls);
		} catch (Exception e) {
			return null;
		} 
	}
	
	public <T> T getEntityForPostPutForObject(Class<T> c){
		logger.info("Post或Put请求（Object）解密后接收到的body参数为："+this.code);
		try {
			//System.out.println(this.code);
			//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			return new ObjectMapper().readValue(this.code,c);
		} catch (Exception e) {
			return null;
		} 
	}

}
