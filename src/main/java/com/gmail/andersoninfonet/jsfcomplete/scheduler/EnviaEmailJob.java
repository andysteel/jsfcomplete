package com.gmail.andersoninfonet.jsfcomplete.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gmail.andersoninfonet.jsfcomplete.tasks.EnviaEmail;

public class EnviaEmailJob implements Job{
	 
	
	public EnviaEmailJob() {
		
	}
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		EnviaEmail mail = new EnviaEmail();
		mail.enviar();

	}
	

}
