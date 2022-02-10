package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_province")
public class Province implements Serializable {

	private static final long serialVersionUID = -7315803979171592175L;
	
	@Column(name="code",pk=true,columnDesc="省代码")
	private String code;//省代码
	
	@Column(name="name",columnDesc="省名称")
	private String name;//省名称

	public static final String codeColumn = "code";
	public static final String nameColumn = "name";
	
}
