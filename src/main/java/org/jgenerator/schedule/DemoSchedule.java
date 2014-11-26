/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-11 下午02:27:33
 * @name FetchNewsSchedule.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author LIZHITAO 定时任务事例
 */
public class DemoSchedule extends QuartzJobBean {

	/**
	 * @param
	 * @name executeInternal
	 * @active
	 * @state
	 * @type String
	 * @time 下午02:27:33
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("这是一个定时");
	}
}
