package com.javaweb.db.mybatis.api.handle;

import java.util.Objects;

import com.javaweb.db.help.SqlBuildInfo;
import com.javaweb.db.help.SqlHandle;
import com.javaweb.enums.DbTypeEnum;
import com.javaweb.exception.ServiceException;

public class HandleUpdate implements SqlHandle {

	public String handle(SqlBuildInfo sqlBuildInfo) {
		if(Objects.equals(DbTypeEnum.MYSQL,sqlBuildInfo.getDbTypeEnum())){
			return mySqlForSqlString.getUpdateStringSql(sqlBuildInfo);
		}else{
			throw new ServiceException("目前只支持mysql数据库");
		}
	}

}
