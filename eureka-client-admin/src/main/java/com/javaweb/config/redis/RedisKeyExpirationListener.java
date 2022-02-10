package com.javaweb.config.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name="redis.key.expire.on",havingValue="true",matchIfMissing=false)
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

	public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}
	
	public void onMessage(Message message, byte[] pattern) {
		String expiredKey = message.toString();
		System.out.println("失效的 key为："+expiredKey); 
	}
	
}
