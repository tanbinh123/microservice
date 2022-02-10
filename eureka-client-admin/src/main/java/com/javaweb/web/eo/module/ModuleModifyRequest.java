package com.javaweb.web.eo.module;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleModifyRequest implements Serializable {

	private static final long serialVersionUID = 754278223750412761L;
	
	private String moduleId;//模块ID

	@Min(value=1,message="validated.module.moduleType.limit")
	@Max(value=3,message="validated.module.moduleType.limit")
	private Integer moduleType = 1;//模块类型

	private String parentId;//上级模块ID

	@NotEmpty(message="validated.module.moduleName.notEmpty")
	@Size(max=20,message="validated.module.moduleName.maxLength.limit")
	private String moduleName;//模块名

	@NotEmpty(message="validated.module.alias.notEmpty")
	@Size(max=20,message="validated.module.alias.maxLength.limit")
	private String alias;//别名

	private String pageUrl;//页面URL

	private String apiUrl;//api的URL

	private String icon;//图标

	private String remark;//备注
	
	private Integer orders = 1;//模块顺序
	
}
