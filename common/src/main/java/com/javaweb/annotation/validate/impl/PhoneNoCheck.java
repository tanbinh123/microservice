package com.javaweb.annotation.validate.impl;

import java.util.regex.Pattern;

import com.javaweb.util.core.StringUtil;

public class PhoneNoCheck {
	
	public static final String REGEX = "1(3|4|5|6|7|8|9)\\d{9}";
	
	public static final Pattern PHONE_NO_PATTERN = Pattern.compile(REGEX);
	
    public static boolean check(String phoneNo){
    	if(StringUtil.isEmpty(phoneNo)){
    		return false;
    	}
    	return PHONE_NO_PATTERN.matcher(phoneNo).matches();
    }

}
