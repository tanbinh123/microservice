package com.javaweb.web.eo.validate;

import com.javaweb.db.query.QueryWapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnsRepeatRequest<T> {
	
	private QueryWapper<T> queryWapper;

	private String message;
	
	public ColumnsRepeatRequest(String columnName,Object columnValue,String message){
		this(null,null,columnName,columnValue,message);
	}

	public ColumnsRepeatRequest(String primaryColumnName,Object primaryColumnValue,String columnName,Object columnValue,String message){
		QueryWapper<T> queryWapper = new QueryWapper<T>();
		queryWapper.eq(columnName,columnValue);
		if(primaryColumnName!=null&&primaryColumnValue!=null){
			queryWapper.neq(primaryColumnName,primaryColumnValue);
		}
		this.queryWapper = queryWapper;
		this.message = message;
	}

}
