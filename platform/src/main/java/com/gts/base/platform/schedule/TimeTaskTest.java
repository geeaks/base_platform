package com.gts.base.platform.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;import org.quartz.JobExecutionException;

public class TimeTaskTest implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.err.println("测试任务调度，6秒一次");
	}

}
