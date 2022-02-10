package com.javaweb.web.eo.user;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRequest implements Serializable {

	private static final long serialVersionUID = 1617989363835358849L;

	@NotEmpty(message="validated.user.userName.notNull")
	@Pattern(regexp="^"+UserLoginRequest.USERNAME_COMMON_REGEXP+"$",message="validated.user.userName.pattern")
	private String userName;//用户名
	
	@NotEmpty(message="validated.user.password.notNull")
	@Pattern(regexp="^"+UserLoginRequest.PASSWORD_COMMON_REGEXP+"$",message="validated.user.password.pattern")
	private String password;//用户密码
	
	@NotEmpty(message="validated.user.personName.notNull")
	@Size(max=20,message="validated.user.personName.maxLength.limit")
	private String personName;//用户姓名
	
	@Size(min=18,max=18,message="validated.user.idCard.maxLength.limit")
	private String idCard;//身份证号码

	@Size(max=50,message="validated.user.email.maxLength.limit")
	private String email;//电子邮箱
	
	@Pattern(regexp="^\\d{11}$",message="validated.user.phone.maxLength.limit")
	private String phone;//手机号码

	@Min(value=0,message="validated.user.status.value.limit")
	@Max(value=1,message="validated.user.status.value.limit")
	private Integer status = 0;//账号状态（0：正常；1：禁用）
	
	@Size(max=100,message="validated.user.remark.maxLength.limit")
	private String remark;//备注
	
}
