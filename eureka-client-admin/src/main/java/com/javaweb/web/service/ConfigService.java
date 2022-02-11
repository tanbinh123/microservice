package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.config.ConfigListRequest;
import com.javaweb.web.po.Config;

public interface ConfigService {
    
    List<Config> selectAll();
    
    List<Config> getConfig(Config config);
    
    void configAdd(Config config);
    
    Page configList(ConfigListRequest configListRequest);
    
    void configModify(Config config);
    
    Config configDetail(String configId);
    
    void configDelete(String configId);
	
}
