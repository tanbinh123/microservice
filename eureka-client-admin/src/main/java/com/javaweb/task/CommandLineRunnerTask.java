package com.javaweb.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.javaweb.annotation.task.DistributedTimedTask;
import com.javaweb.base.BaseService;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.config.redis.RedisMqReceive;
import com.javaweb.web.po.Config;
import com.javaweb.web.po.Dictionary;
import com.javaweb.web.po.Interfaces;

@Order(value=1)
@Component
public class CommandLineRunnerTask extends BaseService implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(CommandLineRunnerTask.class);

    public void run(String... args) throws Exception {
    	Thread taskThread_1 = new Thread(()->{
    		List<Config> list = configService.selectAll();
    		RedisMqReceive.updateConfigInfo(list);
    		logger.info("[将配置表数据加载进内存]执行完毕");
    	});
    	Thread taskThread_2 = new Thread(()->{
    		List<Dictionary> list = dictionaryService.selectAll(); 
    		RedisMqReceive.updateDictionaryInfo(list);
        	logger.info("[将字典表数据加载进内存]执行完毕");
    	});
    	Thread taskThread_3 = new Thread(()->{
    		interfacesService.synchronizedInterfaces();
        	logger.info("[同步数据库中的接口信息表]执行完毕");
        	List<Interfaces> list = interfacesService.getAll();
        	BaseSystemMemory.interfacesList = list;
        	logger.info("[将所有接口信息加载进内存]执行完毕");
        	interfacesService.synchronizedRedisInterfaceHistoryTimes();
        	logger.info("[同步redis中的各个接口调用次数]执行完毕");
    	});
    	taskThread_1.start();taskThread_2.start();taskThread_3.start();
    }
    
    //每隔1小时执行一次（整点）
    @DistributedTimedTask(taskUniqueName="cronTask_1")
	@Scheduled(cron="0 0 */1 * * ?")//https://tool.lu/crontab
	public void cronTask_1(){
    	interfacesService.synchronizedRedisInterfaceHistoryTimes();
    	logger.info("每隔1小时[同步redis中的各个接口调用次数]执行完毕");
	}

}

/**
//也可以有多个类实现CommandLineRunner，多个类都写上@Component即可，若要定义顺序，加上@Order(value=1)即可
@Component
class MyCommandLineRunner implements CommandLineRunner {
public void run(String... args) {
    System.setProperty("spring.devtools.restart.enabled","false");//取消热部署
}
}
*/
