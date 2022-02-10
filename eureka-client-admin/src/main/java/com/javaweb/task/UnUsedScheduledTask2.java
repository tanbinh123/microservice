package com.javaweb.task;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;

//使用请解注
//@Component
public class UnUsedScheduledTask2 implements SchedulingConfigurer {
	
	private ScheduledTaskRegistrar scheduledTaskRegistrar;
    
    private Set<ScheduledFuture<?>> scheduledFutures = ConcurrentHashMap.newKeySet();
    
    private Map<String,ScheduledFuture<?>> taskFutures = new ConcurrentHashMap<>();
    
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar){
		//这里可以从数据库读取已有的定时任务【@Autowired private ConfigService configService;】
		this.scheduledTaskRegistrar = scheduledTaskRegistrar;
	}
	
	public void sendShortMessage(){
		System.out.println(Thread.currentThread().getName()+"：短消息发送成功");
	}
	
	//添加任务
	public void addTriggerTask(String taskId,TriggerTask triggerTask){
		if(taskFutures.containsKey(taskId)){
			System.err.println("任务（"+taskId+"）已经存在，添加任务失败");
		}else{
			TaskScheduler taskScheduler = this.scheduledTaskRegistrar.getScheduler();
			ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(triggerTask.getRunnable(),triggerTask.getTrigger());
			this.scheduledFutures.add(scheduledFuture);
			taskFutures.put(taskId,scheduledFuture);
		}
	}
	 
	//取消任务
	public void cancelTriggerTask(String taskId){
		if(!taskFutures.containsKey(taskId)){
			System.err.println("任务（"+taskId+"）不存在，取消任务失败");
		}else{
			ScheduledFuture<?> scheduledFuture = taskFutures.get(taskId);
			scheduledFuture.cancel(true);
			taskFutures.remove(taskId);
			this.scheduledFutures.remove(scheduledFuture);
		}
	}
	 
	//修改（重置）任务
	public void resetTriggerTask(String taskId,TriggerTask triggerTask){
		if(!taskFutures.containsKey(taskId)){
			System.err.println("任务（"+taskId+"）不存在，修改（重置）任务失败");
		}else{
			cancelTriggerTask(taskId);
			addTriggerTask(taskId,triggerTask);
		}
	}

}

