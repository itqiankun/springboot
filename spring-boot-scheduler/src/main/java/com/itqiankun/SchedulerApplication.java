package com.itqiankun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(50); //线程池活跃的线程数
		pool.setQueueCapacity(5);
		pool.setMaxPoolSize(100); //线程池最大活跃的线程数
		pool.setWaitForTasksToCompleteOnShutdown(true);
		pool.setThreadNamePrefix("lalala");
		return pool;
	}
}
