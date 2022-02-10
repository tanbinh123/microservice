package com.javaweb.web.eo.dbTables;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DbTablesCodeGenerateResponse implements Serializable {

	private static final long serialVersionUID = 5158730273556711645L;

	private String tableColumn;//表列名
	
	private Boolean key;//是否主键
	
	private String javaType;//java类型
	
	private String javaPropertyName;//java属性名称
	
	/**
	private String columnName;//字段名称
	private String columnType;//字段类型
	private String comments;//字段说明
	private boolean primary;//是否主键
	private String javaName;//字段对应的java属性名称
	private String javaType;//字段对应的java类型
	*/
	
}
