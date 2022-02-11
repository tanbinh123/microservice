package com.javaweb.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.validate.CommonlyUsed;
import com.javaweb.enums.CommonCheckEnum;

import lombok.Getter;
import lombok.Setter;

/** 
@com.fasterxml.jackson.annotation.JsonProperty("num")//这样设置后，私有属性名就不必与num一致了
@com.fasterxml.jackson.annotation.JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//日期格式化
@com.fasterxml.jackson.annotation.JsonIgnore或@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown=true)//如果前端传的字段比后端多的时候可以采用此写法
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)//可以设置NULL值
*/
@Getter
@Setter
public class BaseEntity extends BaseValidatedGroup {
	
	@CommonlyUsed(commonCheckEnum=CommonCheckEnum.ID_CARD)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="create_date",columnDesc="创建时间")
	private Date createDate;//创建时间
	
	@Column(name="creator",columnDesc="创建者")
	private String creator;//创建者
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="update_date",columnDesc="更新时间")
	private Date updateDate;//更新时间
	
	@Column(name="updater",columnDesc="更新者")
	private String updater;//更新者
	
	@Column(name="del_flag",columnDesc="删除标记（0:未被删除;1:已被删除）")
	private Integer delFlag = 0;//删除标记（0:未被删除;1:已被删除）
	
	public static final String createDateColumn = "create_date";
	public static final String creatorColumn = "creator";
	public static final String updateDateColumn = "update_date";
	public static final String updaterColumn = "updater";
	public static final String delFlagColumn = "del_flag";

}
