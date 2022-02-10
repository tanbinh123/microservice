package com.javaweb.db.mybatis.api.impl;

import java.util.Map;

import com.javaweb.constant.CommonConstant;
import com.javaweb.context.ApplicationContextHelper;
import com.javaweb.db.help.IdAutoCreate;
import com.javaweb.db.help.SqlBuildInfo;
import com.javaweb.util.core.SecretUtil;

public interface SqlString {
	
	public String getInsertStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getUpdateStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getDeleteStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getSelectAllStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getSelectAllCountStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getSelectByPkStringSql(SqlBuildInfo sqlBuildInfo);

	public String getSelectOneStringSql(SqlBuildInfo sqlBuildInfo);

	public String getSelectListStringSql(SqlBuildInfo sqlBuildInfo);
	
	public String getSelectListCountStringSql(SqlBuildInfo sqlBuildInfo);
	
	/* ------------------------------------------------------------ 华丽的分割线 ------------------------------------------------------------ */
	
	default Object getIdAutoCreate(){
		try{
			Map<String,?> result = ApplicationContextHelper.getInterfaceImpl(IdAutoCreate.class);
			if(result!=null){
				IdAutoCreate<?> idAutoCreate = (IdAutoCreate<?>)result.get(result.keySet().iterator().next());//如果有多个实现，只取最先获取到的第一个
				return idAutoCreate.idCreate();
			}
		}catch(Exception e){
			//do nothing
		}
		return SecretUtil.defaultGenUniqueStr(CommonConstant.ZERO_STRING_VALUE);
	}

}
