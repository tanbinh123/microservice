package com.javaweb.listener;

import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

public class ApplicationEnvironmentListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
		ConfigurableEnvironment configurableEnvironment = applicationEnvironmentPreparedEvent.getEnvironment();
		MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
		mutablePropertySources.forEach(e->{
			//System.out.println(e.getClass().getName());
			if("org.springframework.boot.env.OriginTrackedMapPropertySource".equals(e.getClass().getName())){//当前激活的配置文件信息
				Map<String,Object> map = (Map<String,Object>)e.getSource();
				Set<String> set = map.keySet();
				for(String key:set){
					System.out.println("key：【"+key+"】，value：【"+map.get(key)+"】");
				}
			}
		});
	}

}
