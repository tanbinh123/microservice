package com.javaweb.web.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.dbTables.DbTablesColumnListResponse;
import com.javaweb.web.eo.dbTables.DbTablesListRequest;
import com.javaweb.web.eo.dbTables.DbTablesOperateRequest;

public interface DbTablesService {
	
	Page dbTablesList(DbTablesListRequest dbTablesListRequest);
	
	List<DbTablesColumnListResponse> getTableColumnInfo(String tableName);
	
	void codeGenerate(String tableName,HttpServletResponse httpServletResponse);
	
	void dbTablesReduction();
	
	Object dbTablesOperate(DbTablesOperateRequest dbTablesOperateRequest);
	
}
