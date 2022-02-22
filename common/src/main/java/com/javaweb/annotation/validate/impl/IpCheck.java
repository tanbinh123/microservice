package com.javaweb.annotation.validate.impl;

import java.util.regex.Pattern;

import com.javaweb.util.core.StringUtil;

public class IpCheck {
	
	public static final String REGEX = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
	
	public static final Pattern IP_PATTERN = Pattern.compile(REGEX);
	
    public static boolean check(String ip){
    	if(StringUtil.isEmpty(ip)){
    		return false;
    	}
    	return IP_PATTERN.matcher(ip).matches();
    }

}
