package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_district")
public class District implements Serializable {

	private static final long serialVersionUID = -7023948090274328690L;

	@Column(name="code",pk=true,columnDesc="区代码")
	private String code;//区代码
	
	@Column(name="name",columnDesc="区名称")
	private String name;//区名称
	
	@Column(name="city_code",columnDesc="市代码")
	private String cityCode;//市代码
	
	public static final String codeColumn = "code";
	public static final String nameColumn = "name";
	public static final String cityCodeColumn = "city_code";

}
