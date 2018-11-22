package com.learn.validation.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.learn.validation.config.AppConfig;
import com.learn.validation.entities.Singer;

public class SpringValidatorDemo {
	private static Logger logger = LoggerFactory.getLogger(SpringValidatorDemo.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Singer singer = new Singer();
		singer.setFirstName(null);
		singer.setLastName("Singh");

		Validator singerValidator = ctx.getBean("singerValidator", Validator.class);
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(singer, "Arijit");
		
		ValidationUtils.invokeValidator(singerValidator, singer, result);
		
		List<ObjectError>	errors	=	result.getAllErrors();
		errors.forEach(e->logger.info(e.getCode()));
		
		ctx.close();
	}
}
