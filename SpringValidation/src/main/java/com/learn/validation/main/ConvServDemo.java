package com.learn.validation.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.learn.validation.Singer;
import com.learn.validation.config.AppConfig;

public class ConvServDemo {
	public	static	Logger	logger	=	LoggerFactory.getLogger(ConvServDemo.class);
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Singer	john	=	ctx.getBean("john",Singer.class);
		logger.info("Singer Information :- ",john);
		ctx.close();
	}
}
