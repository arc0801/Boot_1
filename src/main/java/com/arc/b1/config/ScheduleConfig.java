package com.arc.b1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
	
	//멀티 Thread 사용하기 위해서
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		
		taskScheduler.setPoolSize(8);
		
		taskScheduler.setThreadNamePrefix("MyThread-");
		
		taskScheduler.initialize();
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
}
