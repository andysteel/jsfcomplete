package com.gmail.andersoninfonet.jsfcomplete.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.validate.bean.BeanValidationMetadataMapper;

import com.gmail.andersoninfonet.jsfcomplete.validation.NotBlankClientValidationConstraint;

@WebListener
public class AppContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
		
		BeanValidationMetadataMapper.registerConstraintMapping(NotBlank.class, 
				new NotBlankClientValidationConstraint());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
