package com.javaweb.web.docking;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.javaweb.util.core.HttpUtil;

public class DemoSystemDocking {

    public static void main(String[] args) throws Exception {
        String out = HttpUtil.defaultGetRequest("http://www.www.com",null);
        ObjectMapper objectMapper = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                                                        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true)
                                                        .build();
        DemoDockingEntity demoDockingEntity = objectMapper.readValue(out,DemoDockingEntity.class);
        System.out.println(demoDockingEntity.getId()+","+demoDockingEntity.getUserName()+","+demoDockingEntity.getAge());
    }
    
}
