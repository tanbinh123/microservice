package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.web.eo.dbTables.DbTablesListResponse;

@Mapper
public interface DbTablesDao {
	
	List<DbTablesListResponse> getTableList(String tableSchema);
	
	List<Map<String,Object>> getTableColumnInfo(String tableName);

}
