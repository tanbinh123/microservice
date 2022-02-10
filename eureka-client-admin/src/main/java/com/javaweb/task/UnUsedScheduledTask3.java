package com.javaweb.task;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.javaweb.base.BaseInject;
import com.javaweb.util.core.NumberFormatUtil;

//使用请解注
//@Component
//@Async//若该类所有方法都是异步执行方法，则直接在该类上加上@Async即可，类里的方法就不需要都加上@Async了
public class UnUsedScheduledTask3 extends BaseInject {
	
	private Logger logger = LoggerFactory.getLogger(UnUsedScheduledTask3.class);
    
    //每隔60秒执行一次
    @Async
    @Scheduled(fixedDelay=60000)//@Scheduled(fixedRate=60000)
    public void cronTask_2() {
    	Runtime runtime = Runtime.getRuntime();
    	long maxMemory = runtime.maxMemory();
    	long totalMemory = runtime.totalMemory();
    	long freeMemory = runtime.freeMemory();
    	logger.info("每隔60秒[" + 
    	            "可以获得的最大总内存是：" + NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(maxMemory)) + 
    			    "，目前已经分配到的内存是：" + NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(totalMemory)) + 
    			    "，目前使用分配到的内存是：" + NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(totalMemory-freeMemory)) + 
    			    "，目前剩余分配到的内存是：" + NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(freeMemory)) + 
    			    "，还可以获得的最大剩余内存是：" + NumberFormatUtil.getdefaultFormatCapacity(new BigDecimal(maxMemory - (totalMemory - freeMemory))) + 
    			    "]执行完毕");
    }
    
	/** 广播
	@Autowired
	private WebSocketHandleService webSocketHandleService;
	
	User user = new User();
	user.setUserName("超级管理员");
	webSocketHandleService.onMessage("我是超级管理员",user);
	*/
    
    /**
    @Async  
    //public Future<String> task3() throws InterruptedException {
    public void task3() throws InterruptedException {  
        long currentTimeMillis1 = System.currentTimeMillis();  
        Thread.sleep(3000);  
        long currentTimeMillis2 = System.currentTimeMillis();  
        System.out.println("task3任务耗时:"+(currentTimeMillis2-currentTimeMillis1)+"ms");  
        //return new AsyncResult<String>("task3执行完毕");  
    }
    */
	
}
