package com.javaweb.config.redis;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.javaweb.base.BaseService;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.SystemConstant;
import com.javaweb.web.po.Config;
import com.javaweb.web.po.Dictionary;

@Component
public class RedisMqReceive extends BaseService implements MessageListener {

	public void onMessage(Message message,byte[] byteArray) {
		String channel = new String(message.getChannel());//频道名
		//String body = new String(message.getBody());//消息体
		//System.out.println("接收到的消息体为："+body);
		if(SystemConstant.CONFIG_TOPIC.equals(channel)){
			updateConfigInfo(configService.selectAll());//更新配置表
			return;
		}
		if(SystemConstant.DICTIONARY_TOPIC.equals(channel)){
			updateDictionaryInfo(dictionaryService.selectAll());//更新字典表
			return;
		}
		if(SystemConstant.INTERFACES_TOPIC.equals(channel)){
			BaseSystemMemory.interfacesList = interfacesService.getAll();//更新接口表
			return;
		}
	}
	
	public static void updateConfigInfo(List<Config> list){
		BaseSystemMemory.configList = list;
		BaseSystemMemory.keyCodeConfigMap = BaseSystemMemory.configList.stream().collect(Collectors.toMap(Config::getKeyCode,e->e/*Function.identity()*/,(k1,k2)->k1));
	}
	
	public static void updateDictionaryInfo(List<Dictionary> list){
		BaseSystemMemory.dictionaryList = list;
		BaseSystemMemory.keyCodeDictionaryMap = BaseSystemMemory.dictionaryList.stream().collect(Collectors.toMap(Dictionary::getKeyCode,e->e/*Function.identity()*/,(k1,k2)->k1));
	}

}
