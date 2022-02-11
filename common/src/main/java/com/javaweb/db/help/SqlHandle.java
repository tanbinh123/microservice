package com.javaweb.db.help;

import com.javaweb.db.mybatis.api.impl.MySqlForSqlString;

@FunctionalInterface
public interface SqlHandle {
	
	MySqlForSqlString mySqlForSqlString = new MySqlForSqlString();

	String handle(SqlBuildInfo sqlBuildInfo);
	
}
