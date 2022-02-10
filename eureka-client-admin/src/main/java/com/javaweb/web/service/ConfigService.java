package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.config.ConfigListRequest;
import com.javaweb.web.po.Config;

public interface ConfigService {
    
    public List<Config> selectAll();
    
    public List<Config> getConfig(Config config);
    
    public void configAdd(Config config);
    
    public Page configList(ConfigListRequest configListRequest);
    
    public void configModify(Config config);
    
    public Config configDetail(String configId);
    
    public void configDelete(String configId);
	
}
