package com.learn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.learn.config.AppConfig;

public class ScheduledTaskAnnotaionDemo {
	public static void main(String[] args) throws Exception {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		System.in.read();
		ctx.close();
	}
}
