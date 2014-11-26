/**
 * 
 */
package org.jgenerator.schedule;

import java.text.ParseException;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author LIZHITAO
 * 
 */
public class ScheduleList {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			JobDetail job = new JobDetail("job1", Scheduler.DEFAULT_GROUP, MyJobSchedule.class);
			CronTrigger trigger = new CronTrigger("Triggername1", Scheduler.DEFAULT_GROUP, "0 0/1 * * * ?");
			scheduler.scheduleJob(job, trigger);
			scheduler.start(); 

			List<Scheduler> list = scheduler.getCurrentlyExecutingJobs();
			for(Scheduler s : list){
				System.out.println("====================================================" + s.getSchedulerName());
				System.out.println("====================================================" + s.getSchedulerInstanceId());
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
