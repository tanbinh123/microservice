package com.javaweb.web.eo.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.javaweb.annotation.validate.ValueRange;
import com.javaweb.constant.SystemConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest implements Serializable {

	private static final long serialVersionUID = 8226342751622290262L;
	
	public static final String USERNAME_COMMON_REGEXP = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}";
	public static final String PASSWORD_COMMON_REGEXP = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}";
	
	public static final String USERNAME_REGEXP = "^("+SystemConstant.ADMIN_USER_NAME+")||("+USERNAME_COMMON_REGEXP+")$";
	public static final String PASSWORD_REGEXP = "^("+SystemConstant.ADMIN_PASSWORD+")||("+PASSWORD_COMMON_REGEXP+")$";
	
	public static final java.util.regex.Pattern PASSWORD_REGEXP_PATTERN = java.util.regex.Pattern.compile(PASSWORD_REGEXP);
	
	@NotEmpty(message="validated.user.userName.notEmpty")
	@Pattern(regexp=USERNAME_REGEXP,message="validated.user.userName.pattern")
	private String username;
	
	@NotEmpty(message="validated.user.password.notEmpty")
	//@Pattern(regexp=PASSWORD_REGEXP,message="validated.user.password.pattern")
	private String password;
	
	@ValueRange(vauleArray={1,2,3},message="validated.user.clientType.pattern")//自定义校验
	private Integer clientType = 1;//客户端类型（1：PC端（默认）；2：安卓端；3：IOS端）
	
	@ValueRange(vauleArray={1,2,3},message="validated.user.loginWay.pattern")//自定义校验
	private Integer loginWay = 1;//登录方式（1：账号密码登录（默认）；2：二维码扫码登录；3：短信验证码登录）
	
	private String time;//时间戳
	
	private String kaptcha;//图片验证码
	
	private String verifyCode;//短信验证码
	
}
