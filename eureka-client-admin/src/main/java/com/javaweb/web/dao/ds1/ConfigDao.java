package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.db.mybatis.api.DaoWapper;
import com.javaweb.web.eo.config.ConfigListRequest;
import com.javaweb.web.po.Config;

@Mapper
public interface ConfigDao extends DaoWapper<Config> {
    
    List<Config> getConfig(Config config);
    
    List<Config> configList(ConfigListRequest configListRequest);
    
    Long configCount(ConfigListRequest configListRequest);
	
}