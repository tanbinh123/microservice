package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListRequest;
import com.javaweb.web.eo.roleRestrict.RoleRestrictListResponse;
import com.javaweb.web.po.RoleRestrict;

@Mapper
public interface RoleRestrictDao extends DaoWapper<RoleRestrict> {
	
	List<RoleRestrictListResponse> roleRestrictList(RoleRestrictListRequest roleRestrictListRequest);
	
	Long roleRestrictListCount(RoleRestrictListRequest roleRestrictListRequest);
	
}
