package com.gmail.andersoninfonet.jsfcomplete.scheduler;

import org.apache.log4j.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MensagemJob implements Job{

	private final static Logger log = Logger.getLogger(MensagemJob.class);
	
	public MensagemJob(){
		
	}
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		log.info("marcando o tempo do Quartz !!");
		
		System.out.println("JSF 2 + Quartz exemplo !!!");
		
	}
	
	

}
