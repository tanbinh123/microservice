package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaweb.base.BaseServiceValidateResult;
import com.javaweb.base.BaseInject;
import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.db.query.QueryWapper;
import com.javaweb.web.eo.validate.ColumnsRepeatRequest;
import com.javaweb.web.service.ValidateService;

@Service("baseValidateServiceImpl")
public class ValidateServiceImpl extends BaseInject implements ValidateService {
	
	@Override
	public <T> BaseServiceValidateResult isColumnsValueRepeat(ColumnsRepeatRequest<T> columnsRepeatRequest,DaoWapper<T> daoWapper){
		List<ColumnsRepeatRequest<T>> columnsRepeatRequestList = new ArrayList<>();
		columnsRepeatRequestList.add(columnsRepeatRequest);
		return this.isColumnsValueRepeat(columnsRepeatRequestList,daoWapper);
	}
	
	@Override
	public <T> BaseServiceValidateResult isColumnsValueRepeat(List<ColumnsRepeatRequest<T>> columnsRepeatRequestList,DaoWapper<T> daoWapper){
		BaseServiceValidateResult baseServiceValidateResult = new BaseServiceValidateResult();
		baseServiceValidateResult.setValidatePass(true);
		for(ColumnsRepeatRequest<T> eachColumnsRepeatRequest:columnsRepeatRequestList){
			baseServiceValidateResult.setMessage(eachColumnsRepeatRequest.getMessage());
			QueryWapper<T> queryWapper = eachColumnsRepeatRequest.getQueryWapper();
			if(queryWapper!=null){
				List<T> list = daoWapper.selectList(queryWapper);
				if(list!=null&&list.size()>0){
					baseServiceValidateResult.setValidatePass(false);
					break;
				}
			}
		}
		return baseServiceValidateResult;
	}

}
