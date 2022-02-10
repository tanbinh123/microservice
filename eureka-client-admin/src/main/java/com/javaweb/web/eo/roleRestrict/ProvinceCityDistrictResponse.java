package com.javaweb.web.eo.roleRestrict;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceCityDistrictResponse implements Serializable {

	private static final long serialVersionUID = -561645168301038508L;

	private String code;//代码

	private String name;//名称
	
}
