package com.javaweb.db.mybatis.api.impl;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import com.javaweb.constant.CommonConstant;
import com.javaweb.db.help.SqlBuildInfo;
import com.javaweb.db.help.SqlCondition;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.enums.CamelCaseEnum;
import com.javaweb.enums.SqlConditionEnum;
import com.javaweb.util.core.ObjectOperateUtil;
import com.javaweb.util.core.StringUtil;

public class MySqlForSqlString implements SqlString {
	
	public String getInsertStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		String tableName = sqlBuildInfo.getTableName();
		List<Object> entityValueList = sqlBuildInfo.getEntityValueList();
		List<String> columnList = sqlBuildInfo.getColumnList();
		if(sqlBuildInfo.getPkGenerate()){//主键自增的处理
			for(int i=0;i<columnList.size();i++){
				if(Objects.equals(sqlBuildInfo.getPk(),columnList.get(i))){
					columnList.remove(i);
					entityValueList.remove(i);
					break;
				}
			}
		}else{
			for(int i=0;i<columnList.size();i++){
				if(sqlBuildInfo.getIdAutoCreate()&&Objects.equals(sqlBuildInfo.getId(),columnList.get(i))){
					Object idAutoCreate = getIdAutoCreate();
					entityValueList.set(i,idAutoCreate);
					//获取主键的值 start
					try {
						Class<?> cls = sqlBuildInfo.getParameterValue().getClass();
						Method method = cls.getMethod(ObjectOperateUtil.METHOD_SET+StringUtil.camelCaseConvert(columnList.get(i),CamelCaseEnum.FIRST_WORD_UPPER),entityValueList.get(i).getClass());
						method.invoke(sqlBuildInfo.getParameterValue(),idAutoCreate);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//获取主键的值 end
					break;
				}
			}
		}
		stringBuilder.append("insert into ").append(tableName).append("(");
		for(int i=0;i<columnList.size();i++){
			stringBuilder.append(columnList.get(i));
			if(i!=columnList.size()-1){
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(")").append(" values ").append("(");
		for(int i=0;i<entityValueList.size();i++){
			Object eachValue = entityValueList.get(i);
			if(eachValue==null){
				stringBuilder.append("null");
			}else if(eachValue instanceof String){
				stringBuilder.append("'"+entityValueList.get(i)+"'");
			}else{
				stringBuilder.append(entityValueList.get(i));
			}
			if(i!=entityValueList.size()-1){
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(")");
		return stringBuilder.toString();
	}

	public String getUpdateStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		String tableName = sqlBuildInfo.getTableName();
		Object pkValue = null;
		List<Object> entityValueList = sqlBuildInfo.getEntityValueList();
		List<Boolean> canUpdateSetEmptyList = sqlBuildInfo.getCanUpdateSetEmptyList();
		List<String> columnList = sqlBuildInfo.getColumnList();
		stringBuilder.append("update ").append(tableName).append(" set ");
		for(int i=0;i<columnList.size();i++){
			if(Objects.equals(columnList.get(i),sqlBuildInfo.getPk())){
				pkValue = entityValueList.get(i);
			}
			Object eachValue = entityValueList.get(i);
			if(eachValue==null||Objects.equals(CommonConstant.EMPTY_VALUE,eachValue.toString().trim())){
				if(canUpdateSetEmptyList.get(i)){
					stringBuilder.append(columnList.get(i)).append(" = ").append("null"/*eachValue*/);
				}else{
					continue;
				}
			}else if(eachValue instanceof String){
				stringBuilder.append(columnList.get(i)).append(" = ").append("'").append(entityValueList.get(i)).append("'");
			}else{
				stringBuilder.append(columnList.get(i)).append(" = ").append(entityValueList.get(i));
			}
			if(i!=entityValueList.size()-1){
				stringBuilder.append(",");
			}
		}
		if(pkValue instanceof String){
			stringBuilder.append(" where ").append(sqlBuildInfo.getPk()).append(" = ").append("'").append(pkValue).append("'");
		}else{
			stringBuilder.append(" where ").append(sqlBuildInfo.getPk()).append(" = ").append(pkValue);
		}
		return stringBuilder.toString();
	}

	public String getDeleteStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		String tableName = sqlBuildInfo.getTableName();
		List<String> columnList = sqlBuildInfo.getColumnList();
		stringBuilder.append("delete from ").append(tableName).append(" where ");
		for(int i=0;i<columnList.size();i++){
			if(Objects.equals(columnList.get(i),sqlBuildInfo.getPk())){
				stringBuilder.append(sqlBuildInfo.getPk()).append(" = ");
				if(sqlBuildInfo.getParameterValue() instanceof String){
					stringBuilder.append("'"+sqlBuildInfo.getParameterValue()+"'");
				}else{
					stringBuilder.append(sqlBuildInfo.getParameterValue());
				}
				break;
			}
		}
		return stringBuilder.toString();
	}

	public String getSelectAllStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		String tableName = sqlBuildInfo.getTableName();
		List<String> entityList = sqlBuildInfo.getEntityList();
		List<String> columnList = sqlBuildInfo.getColumnList();
		stringBuilder.append("select ");
		for(int i=0;i<entityList.size();i++){
			stringBuilder.append(columnList.get(i)).append(" as ").append(entityList.get(i));
			if(i!=entityList.size()-1){
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(" from ").append(tableName);
		return stringBuilder.toString();
	}

	public String getSelectAllCountStringSql(SqlBuildInfo sqlBuildInfo) {
		String tableName = sqlBuildInfo.getTableName();
		return "select count(1) from " + tableName;
	}

	public String getSelectByPkStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		String tableName = sqlBuildInfo.getTableName();
		List<String> entityList = sqlBuildInfo.getEntityList();
		List<String> columnList = sqlBuildInfo.getColumnList();
		stringBuilder.append("select ");
		for(int i=0;i<entityList.size();i++){
			stringBuilder.append(columnList.get(i)).append(" as ").append(entityList.get(i));
			if(i!=entityList.size()-1){
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(" from ").append(tableName).append(" where ");
		for(int i=0;i<columnList.size();i++){
			if(Objects.equals(columnList.get(i),sqlBuildInfo.getPk())){
				stringBuilder.append(sqlBuildInfo.getPk()).append(" = ");
				if(sqlBuildInfo.getParameterValue() instanceof String){
					stringBuilder.append("'"+sqlBuildInfo.getParameterValue()+"'");
				}else{
					stringBuilder.append(sqlBuildInfo.getParameterValue());
				}
				break;
			}
		}
		return stringBuilder.toString();
	}
	
	public String getSelectOneStringSql(SqlBuildInfo sqlBuildInfo) {
		return this.getSelectListStringSql(sqlBuildInfo) + " limit 1";
	}

	public String getSelectListStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		QueryWapper<?> queryWapper = (QueryWapper<?>)sqlBuildInfo.getParameterValue();
		List<SqlCondition> sqlConditionList = queryWapper.getSqlConditionList();
		String tableName = sqlBuildInfo.getTableName();
		List<String> entityList = sqlBuildInfo.getEntityList();
		List<String> columnList = sqlBuildInfo.getColumnList();
		stringBuilder.append("select ");
		for(int i=0;i<entityList.size();i++){
			stringBuilder.append(columnList.get(i)).append(" as ").append(entityList.get(i));
			if(i!=entityList.size()-1){
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(" from ").append(tableName).append(" where 1=1 ");
		if(sqlConditionList.size()>0){
			for(int i=0;i<sqlConditionList.size();i++){
				SqlCondition sqlCondition = sqlConditionList.get(i);
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.EQ)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" = ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.NEQ)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" != ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LIKE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" like ").append("'%"+sqlCondition.getColumnValue()+"%'");
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LT)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" < ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" <= ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.GT)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" > ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.GE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" >= ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
			}
		}
		if(queryWapper.getIsPaged()){
			stringBuilder.append(" limit "+(queryWapper.getCurrentPage()-1)*queryWapper.getPageSize()+","+queryWapper.getPageSize());
		}
		return stringBuilder.toString();
	}

	public String getSelectListCountStringSql(SqlBuildInfo sqlBuildInfo) {
		StringBuilder stringBuilder = new StringBuilder();
		QueryWapper<?> queryWapper = (QueryWapper<?>)sqlBuildInfo.getParameterValue();
		List<SqlCondition> sqlConditionList = queryWapper.getSqlConditionList();
		String tableName = sqlBuildInfo.getTableName();
		stringBuilder.append("select count(1) from ").append(tableName).append(" where 1=1 ");
		if(sqlConditionList.size()>0){
			for(int i=0;i<sqlConditionList.size();i++){
				SqlCondition sqlCondition = sqlConditionList.get(i);
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.EQ)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" = ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.NEQ)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" != ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LIKE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" like ").append("'%"+sqlCondition.getColumnValue()+"%'");
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LT)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" < ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.LE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" <= ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.GT)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" > ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
				if(sqlCondition.getSqlConditionEnum().compareTo(SqlConditionEnum.GE)==0){
					stringBuilder.append(" and ").append(sqlCondition.getColumnName()).append(" >= ").append(sqlCondition.getColumnValue() instanceof Number ? (sqlCondition.getColumnValue()) : ("'"+sqlCondition.getColumnValue()+"'"));
					continue;
				}
			}
		}
		return stringBuilder.toString();
	}

}
