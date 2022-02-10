package com.javaweb.config.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.javaweb.base.BaseService;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.SystemConstant;

@Component
public class RedisMqReceive extends BaseService implements MessageListener {

	public void onMessage(Message message,byte[] byteArray) {
		String channel = new String(message.getChannel());//频道名
		//String body = new String(message.getBody());//消息体
		//System.out.println("接收到的消息体为："+body);
		if(SystemConstant.CONFIG_TOPIC.equals(channel)){
			//更新配置表
			BaseSystemMemory.configList = configService.selectAll();
			return;
		}
		if(SystemConstant.DICTIONARY_TOPIC.equals(channel)){
			//更新字典表
			BaseSystemMemory.dictionaryList = dictionaryService.selectAll();
			return;
		}
		if(SystemConstant.INTERFACES_TOPIC.equals(channel)){
			//更新接口表
			BaseSystemMemory.interfacesList = interfacesService.getAll();
			return;
		}
	}

}
