package com.javaweb.util.core;

public class ThreadUtil {

	public static Thread[] getThread() {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		int total = Thread.activeCount();
		Thread[] currentThreadArray = new Thread[total];
		threadGroup.enumerate(currentThreadArray);
		/**
		for(Thread eachThread:currentThreadArray){
			System.out.println("线程ID："+eachThread.getId()+"，线程名称："+eachThread.getName());
			if(eachThread.getName().equals("aaa")){
				eachThread.stop();
				eachThread.interrupt();
			}
		}
		*/
		return currentThreadArray;
	}

}
