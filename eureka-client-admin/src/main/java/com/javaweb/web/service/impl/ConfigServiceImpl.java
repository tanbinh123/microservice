package com.javaweb.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseDao;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.config.ConfigListRequest;
import com.javaweb.web.po.Config;
import com.javaweb.web.service.ConfigService;

@Service("configServiceImpl")
public class ConfigServiceImpl extends BaseDao implements ConfigService {

	@Override
    public List<Config> selectAll() {
         return configDao.selectAll();
    }

	@Override
    public List<Config> getConfig(Config config) {
         return configDao.getConfig(config);
    }

    @Transactional
    @Override
	public void configAdd(Config config) {
    	configDao.insert(config);
	}
	
    @Override
	public Page configList(ConfigListRequest configListRequest){
		List<Config> list = configDao.configList(configListRequest);
		long count = configDao.configCount(configListRequest);
		Page page = new Page(configListRequest,list,count);
		return page;
	}

	@Transactional
	@Override
	public void configModify(Config config) {
		configDao.update(config);
	}

	@Override
	public Config configDetail(String configId) {
		return configDao.selectByPk(configId);
	}

	@Transactional
	@Override
	public void configDelete(String configId) {
		String configIdIds[] = configId.split(CommonConstant.COMMA);
		for(String id:configIdIds){
			configDao.delete(id);
		}
	}
	
}
