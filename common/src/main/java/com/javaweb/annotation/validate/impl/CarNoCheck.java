package com.javaweb.annotation.validate.impl;

import java.util.regex.Pattern;

import com.javaweb.util.core.StringUtil;

public class CarNoCheck {
	
	public static final String REGEX = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z][a-zA-Z](([DABCEFGHJK]((?![IO])[a-zA-Z0-9](?![IO]))[0-9]{4})|"
			                          +"([0-9]{5}[DABCEFGHJK]))|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z][A-Z][A-Z0-9]{4}[A-Z0-9挂学警港澳])";
	
	public static final Pattern CAR_NO_PATTERN = Pattern.compile(REGEX);
	
    public static boolean check(String carNo){
    	if(StringUtil.isEmpty(carNo)){
    		return false;
    	}
    	return CAR_NO_PATTERN.matcher(carNo).matches();
    }

}
