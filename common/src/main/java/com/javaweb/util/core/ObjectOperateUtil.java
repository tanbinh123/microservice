package com.javaweb.util.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.javaweb.enums.CamelCaseEnum;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class ObjectOperateUtil {
	
	public static final String METHOD_GET = "get"; 
	
	public static final String METHOD_SET = "set";
	
	public static final Object[] NULL_OBJECT = new Object[]{};//无返回值（void）
	
	public static final Class<?>[] NULL_CLASS = new Class[]{};//无参
	
	public static final ObjectSizeCalculator OBJECT_SIZE_CALCULATOR = new ObjectSizeCalculator(ObjectSizeCalculator.getEffectiveMemoryLayoutSpecification());
	
	/**
	 * 集合对象去重 
	 * @param list 集合对象
	 * @param function function表达式，形如：User::getName
	 * @return List<T> 集合对象
	 */
	//排序：Collections.sort(list,Comparator.comparing(User::getName).thenComparing(User::getAge))
	public static <T,U extends Comparable<? super U>> List<T> objectListDistinct(List<T> list,Function<? super T,? extends U> function){
		List<T> newList = list;
		newList = newList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(function))),ArrayList<T>::new));
		return newList;
	}
	
	//对象拷贝
	public static void copyProperties(Object source,Object target){
		BeanUtils.copyProperties(source,target);
	}
	
	//集合对象拷贝
	public static <T,E> List<E> copyListProperties(List<T> sourceList,Class<E> targetClass) {
		if(sourceList==null||targetClass==null){
			return new ArrayList<E>();
		}
		List<E> eList = new ArrayList<>();
		try{
			for(int i=0;i<sourceList.size();i++){
				E e = targetClass.newInstance();
				BeanUtils.copyProperties(sourceList.get(i),e);
				eList.add(e);
			}
		}catch(Exception e){
			//do nothing
		}
		return eList;
	}
	
	//对象映射转换
	public static List<?> objectMapperConversion(List<?> sourceList,Class<?> target,Map<String,String> map,boolean needAllPropertiesToLowerCase) throws Exception {
		List<Object> targetList = new ArrayList<>();//目标映射列表
		String sourceFiledName,sourceMethodName,targetFiledName,targetMethodName;
		Method sourcetMethod,targetMethod;
		for(int i=0;i<sourceList.size();i++){//遍历源映射列表中的每一个对象
			Object sourceObject = sourceList.get(i);//获得源映射列表中的每一个对象
			Object tarjetObject = target.newInstance();//生成目标对象的实例
			Field[] sourceFields = sourceObject.getClass().getDeclaredFields();//获得源对象的所有属性
			for(int j=0;j<sourceFields.length;j++){//获得源对象的每个属性
				sourceFiledName = sourceFields[j].getName();//获得源对象的属性名称
				targetFiledName = map.get(sourceFiledName);//通过map映射获得目标对象的属性名称
				if(targetFiledName==null){
					continue;
				}
				//得到源对象对应的get方法名称
				sourceMethodName = METHOD_GET+StringUtil.camelCaseConvert(sourceFiledName,CamelCaseEnum.FIRST_WORD_UPPER);
				//拼接获得目标对象的set方法名称
				targetMethodName = METHOD_SET+StringUtil.camelCaseConvert(targetFiledName,CamelCaseEnum.FIRST_WORD_UPPER);
				//得到源对象对应的get方法
				sourcetMethod = sourceObject.getClass().getMethod(sourceMethodName,NULL_CLASS);
				//得到目标对象对应的set方法
				targetMethod = tarjetObject.getClass().getMethod(targetMethodName,sourceFields[j].getType());
				//唤醒目标对象的set方法和源对象的get方法
				targetMethod.invoke(tarjetObject,sourcetMethod.invoke(sourceObject,NULL_OBJECT));
			}
			targetList.add(tarjetObject);
		}
		return targetList;
	}
	
	//获取简单类名
	public static String getSimpleClassName(Class<?> c,CamelCaseEnum camelCaseEnum){
		String simpleName = c.getSimpleName(); 
		if(camelCaseEnum==CamelCaseEnum.FIRST_WORD_LOWER){
			return StringUtil.camelCaseConvert(simpleName,camelCaseEnum);
		}else{
			return simpleName;
		}
	}
	
	/**
	属性排除
	场景注意：在对{"a":"1","b":"2","a":"2"}进行转化时不同的jar包方法有不同的表现
	net.sf.json结果为：{"a":["1","2"],"b":"2"}
	com.alibaba.fastjson结果为：{"a":"2","b":"2"}
	*/
	/**
	写法示例：
	List<A> list = new ArrayList<>();
	A a1 = new A("a",18,"x1");
	A a2 = new A("b",19,"x2");
	A a3 = new A("c",20,"x3");
	list.add(a1);list.add(a2);list.add(a3);
	B b = new B(200,"success",list);
	//请注意：如果code:200变为userName:200，同时data里面要排除的属性也是userName,那么userName:200同样会被排除
	//{"code":200,"data":[{"address":"x1","age":18},{"address":"x2","age":19},{"address":"x3","age":20}],"message":"success"}
	System.out.println(excludeField(b,new String[]{"userName"},false));
	*/
	public static String excludeField(Object obj,String[] excludes,boolean isArray){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonValueProcessor() {
			@Override
			public Object processObjectValue(String arg0,Object arg1,JsonConfig arg2) {
				return DateUtil.dateToLocalDateTime((Date)arg1).format(DateTimeFormatter.ofPattern(DateUtil.DEFAULT_DATETIME_PATTERN));
			}
			@Override
			public Object processArrayValue(Object arg0,JsonConfig arg1) {
				return DateUtil.dateToLocalDateTime((Date)arg0).format(DateTimeFormatter.ofPattern(DateUtil.DEFAULT_DATETIME_PATTERN));
			}
		});
		if(isArray){
			return JSONArray.fromObject(obj,jsonConfig).toString();
		}else{
			return JSONObject.fromObject(obj,jsonConfig).toString();
		}
	}
	
	//json字符串数组转Byte数组
	public static Byte[] jsonArrayString2ByteArray(String jsonArray){
		return (Byte[])JSONArray.toArray(JSONArray.fromObject(jsonArray),Byte.class);
	}
	
	//对象占用的字节数（byte）
	public static long getObjectSize(Object obj){
		//return ObjectSizeCalculator.getObjectSize(obj);
		return OBJECT_SIZE_CALCULATOR.calculateObjectSize(obj);
	}

}
