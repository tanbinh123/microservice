package com.javaweb.config.redis;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

/** 关于布隆过滤器
1、可以使用redis插件形式
2、使用谷歌的com.google.guava
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
//1000000为插入的数据量，0.001为错误率
BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),1000000,0.001);
bloomFilter.put("某个值");
bloomFilter.mightContain("某个值");
注：如果要支持分布式，那么需要改造或者借鉴下com.google.guava源码并整合redis，下面简单介绍下实现：
StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
RedisBloomFilterHelper<CharSequence> redisBloomFilterHelper = new RedisBloomFilterHelper<>(Funnels.stringFunnel(Charsets.UTF_8), 1000000L, 0.001D);
int[] intArray = redisBloomFilterHelper.murmurHashOffset("某个值");
System.out.println(Arrays.toString(intArray));
//存入
for(int i=0;i<intArray.length;i++) {
	stringRedisTemplate.opsForValue().setBit("某个值", intArray[i], true);
}
//校验
boolean flag = true;
for(int i=0;i<intArray.length;i++) {
    if(!stringRedisTemplate.opsForValue().getBit("某个值", intArray[i])) {
    	flag = false;
    }
}
System.out.println(flag);
*/
public class RedisBloomFilterHelper<T> {
	
	private Funnel<T> funnel;

	private int bitSize;
	
	private int numHashFunctions;
	
	
	public RedisBloomFilterHelper(Funnel<T> funnel,long expectedInsertions,double fpp) {
		this.funnel = funnel;
		this.bitSize = (int)optimalNumOfBits(expectedInsertions, fpp);
		this.numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, this.bitSize);
	}
	
    private long optimalNumOfBits(long n, double p) {
	    if (p == 0) {
	      p = Double.MIN_VALUE;
	    }
	    return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }
    
    private int optimalNumOfHashFunctions(long n, long m) {
    	// (m / n) * log(2), but avoid truncation due to division!
    	return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }
    
    public int[] murmurHashOffset(T value) { 
    	int[] offset = new int[numHashFunctions]; 
    	long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong(); 
    	int hash1 = (int) hash64; 
    	int hash2 = (int) (hash64 >>> 32); 
    	for (int i = 1; i <= numHashFunctions; i++) { 
    		int nextHash = hash1 + i * hash2; 
    		if (nextHash < 0) { 
    			nextHash = ~nextHash; 
    		} 
    		offset[i - 1] = nextHash % bitSize; 
    	} return offset; 
    }

}
