package com.javaweb.web.po;

import java.io.Serializable;
import java.math.BigInteger;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;
import com.javaweb.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_interfaces")
public class Interfaces extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6266560002081651008L;

	@Column(name="id",pk=true,columnDesc="主键ID")
	private String id;//主键ID
	
	@Column(name="name",columnDesc="接口名称")
	private String name;//接口名称
	
	@Column(name="url",columnDesc="URL")
	private String url;//URL
	
	@Column(name="class_method",columnDesc="类名方法名")
	private String classMethod;//类名方法名
	
	@Column(name="auth",columnDesc="访问权限")
	private String auth;//访问权限
	
	@Column(name="method",columnDesc="方法名称")
	private String method;//方法名称
	
	@Column(name="times",columnDesc="时间",canUpdateSetEmpty=true)
	private String times;//时间
	
	@Column(name="unit",columnDesc="单位",canUpdateSetEmpty=true)
	private String unit;//单位
	
	@Column(name="counts",columnDesc="次数",canUpdateSetEmpty=true)
	private String counts;//次数
	
	@Column(name="data_permission",columnDesc="数据权限（0:无数据权限；1：有数据权限）")
	private Integer dataPermission;//数据权限（0:无数据权限；1：有数据权限）
	
	@Column(name="log_record",columnDesc="日志记录（0:不记录；1：记录）")
	private Integer logRecord;//日志记录（0:不记录；1：记录）
	
	@Column(name="entity",columnDesc="返回的实体类（主要数据对象）")
	private String entity;//返回的实体类（主要数据对象）
	
	@Column(name="history_times",columnDesc="历史接口被调用次数")
	private BigInteger historyTimes;//历史接口被调用次数
	
	@Column(name="request_data_secret",columnDesc="请求数据加密（0：不加密；1：加密）")
	private Integer requestDataSecret;//请求数据加密（0：不加密；1：加密）
	
	@Column(name="response_data_secret",columnDesc="返回数据加密（0：不加密；1：加密）")
	private Integer responseDataSecret;//返回数据加密（0：不加密；1：加密）
	
	@Column(name="level",columnDesc="接口等级")
	private Integer level = 0;//接口等级（数字越大等级越高，默认0无等级）
	
	@Column(name="remark",columnDesc="备注",canUpdateSetEmpty=true)
	private String remark;//备注
	
	public static final String idColumn = "id";
	public static final String nameColumn = "name";
	public static final String urlColumn = "url";
	public static final String classMethodColumn = "class_method";
	public static final String authColumn = "auth";
	public static final String methodColumn = "method";
	public static final String timesColumn = "times";
	public static final String unitColumn = "unit";
	public static final String countsColumn = "counts";
	public static final String dataPermissionColumn = "data_permission";
	public static final String logRecordColumn = "log_record";
	public static final String entityColumn = "entity";
	public static final String historyTimesColumn = "history_times";
	public static final String requestDataSecretColumn = "request_data_secret";
	public static final String responseDataSecretColumn = "response_data_secret";
	public static final String levelColumn = "level";
	public static final String remarkColumn = "remark";

}
