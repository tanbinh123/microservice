package com.javaweb.web.service;

import java.util.List;

import com.javaweb.base.BaseServiceValidateResult;
import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.validate.ColumnsRepeatRequest;

public interface ValidateService {
	
	//校验字段是否重复
	<T> BaseServiceValidateResult isColumnsValueRepeat(ColumnsRepeatRequest<T> columnsRepeatRequest,DaoWapper<T> daoWapper);
	
	<T> BaseServiceValidateResult isColumnsValueRepeat(List<ColumnsRepeatRequest<T>> columnsRepeatRequestList,DaoWapper<T> daoWapper);
	
	//可以追加其它自定义的业务校验

}
