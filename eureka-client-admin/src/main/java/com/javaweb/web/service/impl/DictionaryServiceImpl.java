package com.javaweb.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.dictionary.DictionaryListRequest;
import com.javaweb.web.po.Dictionary;
import com.javaweb.web.service.DictionaryService;

@Service("dictionaryServiceImpl")
public class DictionaryServiceImpl extends BaseDao implements DictionaryService {

	@Override
    public List<Dictionary> selectAll() {
         return dictionaryDao.selectAll();
    }

	@Override
    public List<Dictionary> getDictionary(Dictionary dictionary) {
         return dictionaryDao.getDictionary(dictionary);
    }

    @Transactional
    @Override
	public void dictionaryAdd(Dictionary dictionary) {
		dictionaryDao.insert(dictionary);
	}
	
    @Override
	public Page dictionaryList(DictionaryListRequest dictionaryListRequest){
		List<Dictionary> list = dictionaryDao.dictionaryList(dictionaryListRequest);
		long count = dictionaryDao.dictionaryCount(dictionaryListRequest);
		Page page = new Page(dictionaryListRequest,list,count);
		return page;
	}

	@Transactional
	@Override
	public void dictionaryModify(Dictionary dictionary) {
		dictionaryDao.update(dictionary);
	}

	@Override
	public Dictionary dictionaryDetail(String dictionaryId) {
		return dictionaryDao.selectByPk(dictionaryId);
	}

	@Transactional
	@Override
	public void dictionaryDelete(String dictionaryId) {
		String dictionaryIds[] = dictionaryId.split(CommonConstant.COMMA);
		for(String id:dictionaryIds){
			dictionaryDao.delete(id);
		}
	}
	
}
