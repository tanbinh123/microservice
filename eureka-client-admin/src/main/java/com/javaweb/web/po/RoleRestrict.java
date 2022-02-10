package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.annotation.sql.Column;
import com.javaweb.annotation.sql.Table;
import com.javaweb.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="sys_role_restrict")
public class RoleRestrict extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6545144959065441613L;

	@Column(name="id",pk=true,idAutoCreate=true,columnDesc="主键ID")
	private String id;//主键ID
	
	@Column(name="role_id",columnDesc="角色ID")
	private String roleId;//角色ID
	
	@Column(name="province",columnDesc="省（不限为all，本省为self）")
	private String province;//省（不限为all，本省为self）
	
	@Column(name="city",columnDesc="市（不限为all，本市为self）")
	private String city;//市（不限为all，本市为self）
	
	@Column(name="district",columnDesc="区（不限为all，本区为self）")
	private String district;//区（不限为all，本区为self）
	
	@Column(name="remark",columnDesc="备注")
	private String remark;//备注
	
	@Column(name="status",columnDesc="状态（0：正常；1：禁用）")
	private Integer status = 0;//状态（0：正常；1：禁用）
	
	@Column(name="restrict_way",columnDesc="限定方式（1：本人，本人的话省市区都为null；2：非本人，非本人的话会填充省市区）")
	private Integer restrictWay;//限定方式（1：本人，本人的话省市区都为null；2：非本人，非本人的话会填充省市区）
	
	public static final String idColumn = "id";
	public static final String roleIdColumn = "role_id";
	public static final String provinceColumn = "province";
	public static final String cityColumn = "city";
	public static final String districtColumn = "district";
	public static final String remarkColumn = "remark";
	public static final String statusColumn = "status";
	public static final String restrictWayColumn = "restrict_way";
	
}
