package com.javaweb.web.eo.onlineUser;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnlineUserListResponse implements Serializable {
	
	private static final long serialVersionUID = -3593474167342088813L;

	private String userId;//用户ID

	private String userName;//用户名称
	
	private String loginTime;//登录时间

	private String onlineTime;//在线时长
	
}
