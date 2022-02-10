package com.javaweb.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.javaweb.constant.CommonConstant;
import com.javaweb.web.po.Config;
import com.javaweb.web.po.Dictionary;
import com.javaweb.web.po.Interfaces;

public class BaseSystemMemory {
    
    public static Map<String,Interfaces> interfacesUrlMap = new HashMap<>();
    
    public static Map<String,RequestMappingInfo> requestMappingUrlMap = new HashMap<>();
    
    public static List<Dictionary> dictionaryList = new ArrayList<>();
    
    public static List<Config> configList = new ArrayList<>(); 

    public static List<Interfaces> interfacesList = new ArrayList<>(); 
    
    public static Interfaces getMatchRequestMapping(HttpServletRequest httpServletRequest){
    	Set<String> set = requestMappingUrlMap.keySet();
    	for(String each:set){
    		RequestMappingInfo requestMappingInfo = requestMappingUrlMap.get(each);
    		if(requestMappingInfo.getMatchingCondition(httpServletRequest)!=null){
    			return interfacesUrlMap.get(each);
    		}
    	}
    	return null;
    }
    
    /* -------------------------------------------------- dictionary -------------------------------------------------- */
    
	public static List<Dictionary> getDictionaryByDataType(String dataType){
        return dictionaryList.stream().filter(each->{return each.getDataType().equals(dataType);}).collect(Collectors.toList());
    }
    
    public static Dictionary getDictionaryByKey(String key){
    	Dictionary dictionary = null;
    	Optional<Dictionary> optional = dictionaryList.stream().filter(each->{return each.getKeyCode().equals(key);}).findFirst();
    	if(optional.isPresent()){
    		dictionary = optional.get();
    	}
    	return dictionary;
    }
    
    public static String getDictionaryValueByKey(String key){
    	String value = CommonConstant.NULL_VALUE;
    	Dictionary dictionary = getDictionaryByKey(key);
    	if(dictionary!=null){
    		value = dictionary.getValueCode();
    	}
    	return value;
    }
    
    public static String getDictionaryValueByKey(String key,String defaultValue){
    	String value = getDictionaryValueByKey(key);
    	if(value==CommonConstant.NULL_VALUE){
    		value = defaultValue;
    	}
    	return value;
    }
    
    /* -------------------------------------------------- config -------------------------------------------------- */
    
	public static List<Config> getConfigByDataType(String dataType){
        return configList.stream().filter(each->{return each.getDataType().equals(dataType);}).collect(Collectors.toList());
    }
    
    public static Config getConfigByKey(String key){
    	Config config = null;
    	Optional<Config> optional = configList.stream().filter(each->{return each.getKeyCode().equals(key);}).findFirst();
    	if(optional.isPresent()){
    		config = optional.get();
    	}
    	return config;
    }
    
    public static String getConfigValueByKey(String key){
    	String value = CommonConstant.NULL_VALUE;
    	Config config = getConfigByKey(key);
    	if(config!=null){
    		value = config.getValueCode();
    	}
    	return value;
    }
    
    public static String getConfigValueByKey(String key,String defaultValue){
    	String value = getConfigValueByKey(key);
    	if(value==CommonConstant.NULL_VALUE){
    		value = defaultValue;
    	}
    	return value;
    }
    
}
