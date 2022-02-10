package com.javaweb.aspect;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.javaweb.annotation.task.DistributedTimedTask;
import com.javaweb.base.BaseInject;
import com.javaweb.constant.SystemConstant;

@Aspect
@Component
public class DistributedTimedTaskAspect extends BaseInject {
	
	private Logger logger = LoggerFactory.getLogger(DistributedTimedTaskAspect.class);

	//@Around(value="execution(* *.*(..)) && @annotation(com.javaweb.annotation.task.DistributedTimedTask)")
	//@Around(value="execution(* com.javaweb.task.*.*(..)) && @annotation(com.javaweb.annotation.task.DistributedTimedTask)")
	@Around(value=SystemConstant.DEFAULT_DISTRIBUTED_TIMED_TASK_POINT_CUT)
	public void redisTryLockPoint(ProceedingJoinPoint joinPoint) {
		try{
			Class<?> c = joinPoint.getTarget().getClass();
			String name = joinPoint.getSignature().getName();
			Method method = c.getMethod(name);
			DistributedTimedTask annotation = method.getAnnotation(DistributedTimedTask.class);
			String taskUniqueName = annotation.taskUniqueName();
			//防止锁不被释放，该值最好兼容多台服务器的时间差同时定时任务的执行频率不应该小于该值，一般认为多台服务器时间差最多为30秒
			boolean getFlag = valueOperations.setIfAbsent(taskUniqueName,SystemConstant.DISTRIBUTED_TIMED_TASK_KEY,30,TimeUnit.SECONDS);
			logger.info("当前服务器获取redis分布式锁状态为："+getFlag+"，即"+(getFlag==true?"获取到锁":"没有获取到锁"));
			if(getFlag){
				logger.info("当前服务器由于[有]获取到锁，所以[需要]执行定时任务");
				try {
					joinPoint.proceed();
				} catch (Throwable e) {
					logger.error(e.getMessage());
				}
			}else{
				logger.info("当前服务器由于[没有]获取到锁，所以[无需]执行定时任务");
			}
		}catch(Throwable e){
			logger.error(e.getMessage());
		}
	}
	
}
