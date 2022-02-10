package com.javaweb.base;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.util.core.ObjectOperateUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseResult implements Serializable {

	private static final long serialVersionUID = -3883891531784970360L;

	private Object code;//返回码
	
	private Object message;//返回信息
	
	private Object data;//返回数据
	
	private Integer secret;//返回数据是否加密（0：不加密（默认）；1：加密）
	
	private List<String> fieldList;//去除指定属性的列表
	
	public BaseResponseResult(){
		
	}
	
	public BaseResponseResult(Object code){
		this(code,null,null);
	}
	
	public BaseResponseResult(Object code,Object message){
		this(code,message,null);
	}
	
	public BaseResponseResult(Object code,Object message,Object data){
		this(code,message,data,0,null);
	}
	
	//该方法不大成熟、完善，所以不推荐使用（@Link GlobalResponseBodyHandler）
	@Deprecated
	public BaseResponseResult(Object code,Object message,Object data,List<String> fieldList){
		this.code = code;
		this.message = message;
		if(fieldList==null||fieldList.size()<=0){
			this.data = data;
		}else{
			String array[] = new String[fieldList.size()];
			for(int i=0;i<fieldList.size();i++){
				array[i] = fieldList.get(i);
			}
			boolean arrayFlag = false; 
			if(data instanceof List||data instanceof String[]){
				arrayFlag = true; 
			}
			String out = ObjectOperateUtil.excludeField(data,array,arrayFlag);
			try {
				/** 数组的处理
				Test[] array = new ObjectMapper().readValue(str,Test[].class);
				List<Test> list = Arrays.asList(array);
				*/
				this.data = new ObjectMapper().readValue(out,data.getClass());
			}catch(Exception e) {
				this.data = data;
			}		
		}
	}
	
	public BaseResponseResult(Object code,Object message,Object data,Integer secret,List<String> fieldList){
		this.code = code;
		this.message = message;
		this.data = data;
		this.secret = secret;
		this.fieldList = fieldList;
	}

}
