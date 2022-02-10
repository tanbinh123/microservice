package com.javaweb.config.redis;

import java.time.Duration;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.javaweb.constant.SystemConstant;

/**
常用命令：
字符串：get、mget、set、mset、getset、del、strlen、append、incr、incrby、decr、decrby、incrbyfloat、decrbyfloat
散列：hset、hget、hincrby、hincrbyfloat、hexists、hdel、hlen、hmset、hmget、hkeys、hvals、hgetall
列表：lpush、rpush、lpushx、rpushx、lpop、rpop、rpoplpush、llen、lindex、lrange（所有就是0到-1）、lset、linsert、ltrim、lrem、blpop、brpop、brpoplpush
集合：sadd、srem、smove、smembers、scard、sismember、srandmember、spop、sinter（交集）、sinterstore（交集）、sunion（并集）、sunionstore（并集）、sdiff（差集）、sdiffstore（差集）
有序集合：zadd、zrem、zscore、zincrby、zcard、zrank、zrevrank、zrange、zrevrange、zrangebyscore、zrevrangebyscore、zcount、zremrangebyrank、zremrangebyscore、zunionstore、zinterstore、zrangebylex、zrevrangebylex、zlexcount、zremrangebylex、zpopmax、zpopmin、bzpopmax、bzpopmin
集合计算：pfadd、pfcount、pfmerge（并集）
位图：setbit、getbit、bitcount、bitpos、bitop（位运算）、bitfield
坐标：geoadd、geopos、geodist、georadius、georadiusbymember、geohash
流：xadd、xtrim、xdel、xrange、xrevrange、xread、xgroup、xreadgroup、xpending、xinfo、xack、xclaim
数据库：keys、[h/s/z]scan、sort、exists、dbsize、type、rename、renamenx、move、del、unlink、flushdb、flushall、swapdb
过期：expire、pexpire、expireat、pexpireat、ttl、pttl
事务：multi、exec、discard、watch、unwatch
持久化：save、bgsave、shutdown
发布与订阅：publish、subscribe、unsubscribe、psubscribe、punsubscribe、pubsub
*/
@Configuration
@EnableCaching
public class RedisConfig {
	
	@Autowired
	private RedisParameter redisParameter;
	
	//redis连接
	public RedisConnectionFactory getRedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(redisParameter.getHost());
		redisStandaloneConfiguration.setPassword(redisParameter.getPassword());
		redisStandaloneConfiguration.setPort(redisParameter.getPort());
		GenericObjectPoolConfig<?> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
		genericObjectPoolConfig.setMinIdle(redisParameter.getMinIdle());
		genericObjectPoolConfig.setMaxIdle(redisParameter.getMaxIdle());
		genericObjectPoolConfig.setMaxTotal(redisParameter.getMaxTotal());
		genericObjectPoolConfig.setMaxWait(Duration.ofMillis(redisParameter.getMaxWaitMillis()));
		LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder().commandTimeout(Duration.ofMillis(redisParameter.getCommandTimeout())).poolConfig(genericObjectPoolConfig).build();
		LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration,lettuceClientConfiguration);
		//factory.setDatabase(0);//默认0（可选值：0-15）
		//factory.setValidateConnection(true);//连接校验
		factory.afterPropertiesSet();//必须初始化实例
		return factory;
	}
	
    @Bean("redisTemplate")
	public StringRedisTemplate redisTemplate(){
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(getRedisConnectionFactory());
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL,Visibility.ANY);
		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		stringRedisTemplate.afterPropertiesSet();
		return stringRedisTemplate;
	}
    
    //redis消息监听
    @Bean
    public RedisMessageListenerContainer container(@Qualifier("listenerAdapter")MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(getRedisConnectionFactory());
        //可以添加多个 messageListener，配置不同的交换机。但是如果是多个的话，接收消息时就需要判断不同的主题进行不同的业务逻辑处理
        container.addMessageListener(messageListenerAdapter,new PatternTopic(SystemConstant.CONFIG_TOPIC));
        container.addMessageListener(messageListenerAdapter,new PatternTopic(SystemConstant.DICTIONARY_TOPIC));
        container.addMessageListener(messageListenerAdapter,new PatternTopic(SystemConstant.INTERFACES_TOPIC));
        return container;
    }
    
    //redis消息监听适配
    @Bean("listenerAdapter")
    public MessageListenerAdapter listenerAdapter(RedisMqReceive redisMqReceive) {
        return new MessageListenerAdapter(redisMqReceive,"onMessage");
    }
    
}
