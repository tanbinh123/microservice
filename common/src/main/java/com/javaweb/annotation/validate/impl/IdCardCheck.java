package com.javaweb.annotation.validate.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.javaweb.util.core.StringUtil;

//身份证校验逻辑
public class IdCardCheck {

	private final static String BIRTH_DATE_FORMAT = "yyyyMMdd";//身份证号码中的出生日期的格式

    private final static Date MINIMAL_BIRTH_DATE = new Date(-2209017600000L);//身份证的最小出生日期，1900年1月1日

    private final static int NEW_CARD_NUMBER_LENGTH = 18;

	private final static int OLD_CARD_NUMBER_LENGTH = 15;

	private final static char[] VERIFY_CODE = {'1','0','X','9','8','7','6','5','4','3','2'};//18位身份证中最后一位校验码

	private final static int[] VERIFY_CODE_WEIGHT = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};//18位身份证中，各个数字的生成校验码时的权值
	
    private final static Map<String,String> PROVINCE_MAP = new HashMap<String,String>(){
    	
    	private static final long serialVersionUID = 1L;
    	{
	        put("11", "北京");
	        put("12", "天津");
	        put("13", "河北");
	        put("14", "山西");
	        put("15", "内蒙古");
	        put("21", "辽宁");
	        put("22", "吉林");
	        put("23", "黑龙江");
	        put("31", "上海");
	        put("32", "江苏");
	        put("33", "浙江");
	        put("34", "安徽");
	        put("35", "福建");
	        put("36", "江西");
	        put("37", "山东");
	        put("41", "河南");
	        put("42", "湖北");
	        put("43", "湖南");
	        put("44", "广东");
	        put("45", "广西");
	        put("46", "海南");
	        put("50", "重庆");
	        put("51", "四川");
	        put("52", "贵州");
	        put("53", "云南");
	        put("54", "西藏");
	        put("61", "陕西");
	        put("62", "甘肃");
	        put("63", "青海");
	        put("64", "宁夏");
	        put("65", "新疆");
	        put("71", "台湾");
	        put("81", "香港");
	        put("82", "澳门");
    	}
    	
    };
	
	//如果是15位身份证号码，则自动转换为18位
    public static boolean check(String cardNumber){
    	if(StringUtil.isEmpty(cardNumber)){
    		return false;
    	}
        cardNumber = cardNumber.trim();
        if (OLD_CARD_NUMBER_LENGTH == cardNumber.length()){
            cardNumber = contertToNewCardNumber(cardNumber);
        }
        return validate(cardNumber);
    }
    
    public static String getPrivince(String cardNumber){
    	return PROVINCE_MAP.get(cardNumber.substring(0, 2));
    }
    
    private static boolean validate(String cardNumber){
        boolean result = true;
        result = result && (null != cardNumber); // 身份证号不能为空
        result = result && NEW_CARD_NUMBER_LENGTH == cardNumber.length(); // 身份证号长度是18(新证)
        //身份证号的前17位必须是阿拉伯数字
        for (int i = 0; result && i < NEW_CARD_NUMBER_LENGTH - 1; i++){
            char ch = cardNumber.charAt(i);
            result = result && ch >= '0' && ch <= '9';
        }
        //身份证号的第18位校验正确
        result = result && (calculateVerifyCode(cardNumber) == cardNumber.charAt(NEW_CARD_NUMBER_LENGTH - 1));
        //出生日期不能晚于当前时间，并且不能早于1900年
        try{
            Date birthDate = new SimpleDateFormat(BIRTH_DATE_FORMAT).parse(getBirthDayPart(cardNumber));
            result = result && null != birthDate;
            result = result && birthDate.before(new Date());
            result = result && birthDate.after(MINIMAL_BIRTH_DATE);
            //出生日期中的年、月、日必须正确，比如月份范围是[1,12]，日期范围是[1,31]，还需要校验闰年、大月、小月的情况时，月份和日期相符合
            String birthdayPart = getBirthDayPart(cardNumber);
            String realBirthdayPart = new SimpleDateFormat(BIRTH_DATE_FORMAT)
                    .format(birthDate);
            result = result && (birthdayPart.equals(realBirthdayPart));
        }catch(Exception e){
            result = false;
        }
        return result;
    }
    
    private static String getBirthDayPart(String cardNumber){
        return cardNumber.substring(6, 14);
    }

    //校验码（第十八位数）：
    private static char calculateVerifyCode(CharSequence cardNumber){
        int sum = 0;
        for (int i = 0; i < NEW_CARD_NUMBER_LENGTH - 1; i++){
            char ch = cardNumber.charAt(i);
            sum += ((int) (ch - '0')) * VERIFY_CODE_WEIGHT[i];
        }
        return VERIFY_CODE[sum % 11];
    }
    
    private static String contertToNewCardNumber(String oldCardNumber){
        StringBuilder buf = new StringBuilder(NEW_CARD_NUMBER_LENGTH);
        buf.append(oldCardNumber.substring(0, 6));
        buf.append("19");
        buf.append(oldCardNumber.substring(6));
        buf.append(calculateVerifyCode(buf));
        return buf.toString();
    }
	
}
