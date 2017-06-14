package dev.script;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class JobTraitementDeNuit implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		this.executeNow();

	}
	
	public void executeNow(){
		System.err.println("MyJob is executing.");
	}

}
