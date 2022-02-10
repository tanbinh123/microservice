package com.javaweb.util.entity;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.javaweb.util.core.PageUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
  
	private Long currentPage = 1L;//默认当前第1页
	
	private Long pageSize = 10L;//默认每页显示10条 
	
	private Long totalSize = 0L;//默认一共0条数据
	
	private Long totalPage = 0L;//默认一共0页
	
	private Object data;//数据
	
	private List<Long> pageList;//分页页数
	
	@SuppressWarnings("unchecked")
	public Page(Object pageParam,Object data,Long totalSize){
		this.data = data;
		this.totalSize = totalSize;
		try{
			if(pageParam instanceof Map){//支持Map类型
				Map<Object,Object> map = (Map<Object,Object>)pageParam;
				this.currentPage = (Long)map.get("currentPage");
				this.pageSize = (Long)map.get("pageSize");
			}else{//支持Bean对象类型
				Class<?> cls = pageParam.getClass();
				Queue<Class<?>> queue = new LinkedList<>();
				getDeepSuperClass(cls,queue);
				Iterator<Class<?>> it = queue.iterator();
				while(it.hasNext()){
					cls = it.next();
					Field fieldCurrentPage = null;
					Field fieldPageSize = null;
					try{
						fieldCurrentPage = cls.getDeclaredField("currentPage");
						//fieldCurrentPage = cls.getField("currentPage");
						fieldPageSize = cls.getDeclaredField("pageSize");
						//fieldPageSize = cls.getField("pageSize");
					}catch(NoSuchFieldException e1){
						//do nothing
					}
					if(fieldCurrentPage!=null&&fieldPageSize!=null){
						fieldCurrentPage.setAccessible(true);  
						fieldPageSize.setAccessible(true);
						this.currentPage = (Long)fieldCurrentPage.get(pageParam);
						this.pageSize = (Long)fieldPageSize.get(pageParam);
						break;
					}
				}
			}
		}catch(Exception e2){
			e2.printStackTrace();
			//do nothing
		}
		this.totalPage = PageUtil.getTotalPage(totalSize,pageSize);
		this.pageList = PageUtil.getShowPages(currentPage,totalPage,5L);
	}
	
	private final void getDeepSuperClass(Class<?> cls,Queue<Class<?>> queue){
		if((cls!=null) && (!"Object".equals(cls.getSimpleName()))){
			queue.add(cls);//队列先进先出，优先获取本类
			getDeepSuperClass(cls.getSuperclass(),queue);
		}
	}

}
