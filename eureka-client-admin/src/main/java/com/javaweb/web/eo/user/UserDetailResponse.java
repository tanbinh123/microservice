package com.javaweb.web.eo.user;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailResponse implements Serializable {

	private static final long serialVersionUID = -6260793844726077746L;

	private String userName;//用户名

	private String personName;//用户姓名

	private String idCard;//身份证号码

	private String email;//电子邮箱

	private String phone;//手机号码

	private Integer status;//用户状态

	private String remark;//备注

}
