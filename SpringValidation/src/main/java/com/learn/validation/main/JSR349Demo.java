package com.learn.validation.main;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.learn.validation.SingerValidationService;
import com.learn.validation.config.AppConfig;
import com.learn.validation.entities.Singer;

public class JSR349Demo {
	private static Logger logger = LoggerFactory.getLogger(JSR349Demo.class);

	public static void main(String[]	args) {

		GenericApplicationContext	ctx	=	
				new	AnnotationConfigApplicationContext(AppConfig.class);
		
		SingerValidationService	singerValidation	=	
					ctx.getBean(SingerValidationService.class);
		
		Singer singer = new Singer();
		singer.setFirstName("Marshall");
		singer.setLastName("Mathers");
		singer.setGenre(null);
		singer.setGender("M");
		
		validateSinger(singer,singerValidation);
		
		ctx.close();
	}
	
	private	static	void	validateSinger(Singer	singer,SingerValidationService	service) {
		Set<ConstraintViolation<Singer>>	violations	=	service.validateSinger(singer);
		listViolations(violations);
	}
	
	private	static	void	listViolations(Set<ConstraintViolation<Singer>>	violationSet) {
		logger.info("Number of violation in for validation : " + violationSet.size());
		for(ConstraintViolation<Singer>	violation	:	violationSet) {
			logger.info("Violation error path for property:"+
			violation.getPropertyPath()
			+"with value : "+ violation.getInvalidValue()
			+"with error message : "+violation.getMessage());
		}
	}
}
