package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_city")
public class City implements Serializable {

	private static final long serialVersionUID = 7056155938133171537L;

	@Column(name="code",pk=true,columnDesc="市代码")
	private String code;//市代码
	
	@Column(name="name",columnDesc="市名称")
	private String name;//市名称
	
	@Column(name="province_code",columnDesc="省代码")
	private String provinceCode;//省代码
	
	public static final String codeColumn = "code";
	public static final String nameColumn = "name";
	public static final String provinceCodeColumn = "province_code";

}
