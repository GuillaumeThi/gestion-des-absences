package dev.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import dev.script.JobTraitementDeNuit;

@Service
public class ScheduleService {
	
	@Autowired JobTraitementDeNuit jobDeNuit;
	
	public void executeSchedule() throws SchedulerException{
		//Indication pour le cronSchedule "sec min heure jour mois jourDeLaSemaine année(optionnel)"
		//Pour plus de détail visiter https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm
		String cronExpression = "0 30 22 * * ?";
		
		// Grab the Scheduler instance from the Factory
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		// and start it off
		scheduler.start();
		  
		// define the job and tie it to our MyJob class
		JobDetail job = newJob(JobTraitementDeNuit.class)
				.withIdentity("job1", "group1")
				.build();

		// Trigger the job to run
		Trigger trigger = newTrigger()
	    	     .withIdentity("trigger1", "group1")
	    	     .startNow()
	    	     .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
	    	     .build();

		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
	}
	
	public void executeTraitementNow(){
		this.jobDeNuit.executeNow();
	}
	
}
