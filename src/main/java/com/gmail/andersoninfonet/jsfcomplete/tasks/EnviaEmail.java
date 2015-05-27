package com.gmail.andersoninfonet.jsfcomplete.tasks;


import com.gmail.andersoninfonet.jsfcomplete.util.email.EmailFactory;


public class EnviaEmail{

	private EmailFactory email = new EmailFactory();
	
	public void enviar(){
		System.out.println("testando email quartz ...");
		System.out.println("enviando email quartz ...");
		email.enviaEmail("andysteel_2@hotmail.com", "Testando Quartz", "Ola mundo, email quartz !!!");
		System.out.println("email quartz enviado !!");
	}
		
}
