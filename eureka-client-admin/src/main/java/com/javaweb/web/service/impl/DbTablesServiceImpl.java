package com.javaweb.web.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.core.FreemarkerUtil;
import com.javaweb.util.core.PageUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.util.entity.SqlConnection;
import com.javaweb.util.help.sql.BaseSql;
import com.javaweb.util.help.sql.MySqlHandle;
import com.javaweb.web.eo.dbTables.DbTablesCodeGenerateResponse;
import com.javaweb.web.eo.dbTables.DbTablesColumnListResponse;
import com.javaweb.web.eo.dbTables.DbTablesListRequest;
import com.javaweb.web.eo.dbTables.DbTablesListResponse;
import com.javaweb.web.eo.dbTables.DbTablesOperateRequest;
import com.javaweb.web.service.DbTablesService;

@Service("dbTablesServiceImpl")
public class DbTablesServiceImpl extends BaseDao implements DbTablesService {

	@Override
	public Page dbTablesList(DbTablesListRequest dbTablesListRequest) {
		List<DbTablesListResponse> tablelist = dbTablesDao.getTableList("test");
		if(tablelist==null||tablelist.size()<=0){
			tablelist = new ArrayList<>();
		}
		if(!(StringUtil.handleNullString(dbTablesListRequest.getTableName()).equals(CommonConstant.EMPTY_VALUE))){
			tablelist = tablelist.stream().filter(e->e.getTableName().contains(dbTablesListRequest.getTableName())).collect(Collectors.toList());
		}
		tablelist = PageUtil.getSubList(tablelist,dbTablesListRequest.getPageSize(),dbTablesListRequest.getCurrentPage());
		long count = tablelist.size();
		Page page = new Page(dbTablesListRequest,tablelist,count);
		return page;
	}
	
	@Override
	public List<DbTablesColumnListResponse> getTableColumnInfo(String tableName) {
		List<DbTablesColumnListResponse> result = new ArrayList<>();
		List<Map<String,Object>> list = dbTablesDao.getTableColumnInfo(tableName);
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = list.get(i);
			DbTablesColumnListResponse dbTablesColumnListResponse = new DbTablesColumnListResponse();
			dbTablesColumnListResponse.setField(StringUtil.object2String(map.get("COLUMN_NAME")));
			dbTablesColumnListResponse.setType(StringUtil.object2String(map.get("COLUMN_TYPE")));
			dbTablesColumnListResponse.setIsNull(StringUtil.object2String(map.get("IS_NULLABLE")));
			dbTablesColumnListResponse.setComment(StringUtil.object2String(map.get("COLUMN_COMMENT")));
			dbTablesColumnListResponse.setDefaultValue(StringUtil.object2String(map.get("COLUMN_DEFAULT")));
			dbTablesColumnListResponse.setIsKey(StringUtil.object2String(map.get("COLUMN_KEY")));
			result.add(dbTablesColumnListResponse);
		}
		return result;
	}

	@Override
	public void codeGenerate(String tableName,HttpServletResponse httpServletResponse) {
		String tableNames[] = tableName.split(CommonConstant.UNDERLINE);
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<tableNames.length;i++){
			stringBuilder.append(tableNames[i].substring(0,1).toUpperCase()).append(tableNames[i].substring(1,tableNames[i].length()));
		}
		String className = stringBuilder.toString();
		List<DbTablesCodeGenerateResponse> result = new ArrayList<>();
		/** oracle
		select t1.*,t2.constraint_type from
		(
		select utc.column_name,utc.data_type,ucc.comments 
		from user_tab_columns utc,user_col_comments ucc 
		where utc.column_name = ucc.column_name
		and utc.table_name = 'test' and ucc.table_name = 'test' 
		order by utc.column_id asc
		) t1 left join 
		(
		select i.COLUMN_NAME,c.CONSTRAINT_TYPE
		from user_constraints c,USER_IND_COLUMNS i
		where c.TABLE_NAME = i.TABLE_NAME  and c.INDEX_NAME = i.INDEX_NAME
		and c.table_name = 'test'
		) t2
		on t1.column_name = t2.column_name
		*/
		List<Map<String,Object>> list = dbTablesDao.getTableColumnInfo(tableName);
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = list.get(i);
			DbTablesCodeGenerateResponse dbTablesCodeGenerateResponse = new DbTablesCodeGenerateResponse();
			dbTablesCodeGenerateResponse.setTableColumn(map.get("COLUMN_NAME").toString());
			dbTablesCodeGenerateResponse.setKey((map.get("COLUMN_KEY")!=null&&map.get("COLUMN_KEY").equals("PRI"))?true:false);
			stringBuilder = new StringBuilder();
			String fields[] = map.get("COLUMN_NAME").toString().split(CommonConstant.UNDERLINE);
			for(int j=0;j<fields.length;j++){
				if(j==0){
					stringBuilder.append(fields[j]);
				}else{
					stringBuilder.append(fields[j].substring(0,1).toUpperCase()).append(fields[j].substring(1,fields[j].length()));
				}
			}
			dbTablesCodeGenerateResponse.setJavaPropertyName(stringBuilder.toString());
			String type = map.get("COLUMN_TYPE")==null?null:String.valueOf(map.get("COLUMN_TYPE"));
			if(type==null){
				type = "String";
			}else{
				if(type.toLowerCase().contains("varchar")){
					type = "String";
				}else if(type.toLowerCase().contains("int")){
					type = "Integer";
				}else if(type.toLowerCase().contains("long")){
					type = "Long";
				}else{
					type = "String";
				}
			}
			dbTablesCodeGenerateResponse.setJavaType(type);
			result.add(dbTablesCodeGenerateResponse);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("tableName",tableName);
		map.put("className",className);
		map.put("propertyList",result);
		String templateFileName[] = {"dao.ftl","mapper.ftl","po.ftl","serviceImpl.ftl","service.ftl"};
		try{
			ZipOutputStream zipOutputStream = new ZipOutputStream(httpServletResponse.getOutputStream());
			FreemarkerUtil.freemarkerForDbTablesCodeGenerate(map,templateFileName,tableName,zipOutputStream);
		}catch(Exception e){
			//do nothing
		}
	}

	@Override
	public void dbTablesReduction() {
		try{
			String filePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource("sql/init.sql").getPath(),"UTF-8");
			BaseSql baseSql = new MySqlHandle();
			SqlConnection jdbcBean = new SqlConnection();
			baseSql.executeImport(jdbcBean,filePath);
		}catch(Exception e){
			//要使用此导入功能需要服务器命令行支持mysql命令
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public Object dbTablesOperate(DbTablesOperateRequest dbTablesOperateRequest) {
		//1：查询；2：插入；3：修改；4：删除
		if(dbTablesOperateRequest.getOperateType()!=null){
			if(dbTablesOperateRequest.getOperateType()==1){
				return commonDao.sqlSelect(dbTablesOperateRequest.getSql());
			}
			if(dbTablesOperateRequest.getOperateType()==2){
				return commonDao.sqlInsert(dbTablesOperateRequest.getSql());
			}
			if(dbTablesOperateRequest.getOperateType()==3){
				return commonDao.sqlUpdate(dbTablesOperateRequest.getSql());
			}
			if(dbTablesOperateRequest.getOperateType()==4){
				return commonDao.sqlDelete(dbTablesOperateRequest.getSql());
			}
		}
		return null;
	}
	
}
