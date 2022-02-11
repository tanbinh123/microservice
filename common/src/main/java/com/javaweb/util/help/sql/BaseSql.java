package com.javaweb.util.help.sql;

import com.javaweb.util.entity.SqlConnection;

public interface BaseSql {
	
	boolean executeExport(SqlConnection jdbcBean, String filePath) throws Exception;//导出
	
	boolean executeImport(SqlConnection jdbcBean, String filePath) throws Exception;//导入

}
