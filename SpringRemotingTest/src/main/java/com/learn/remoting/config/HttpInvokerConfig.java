package com.learn.remoting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.learn.remoting.services.SingerService;

public class HttpInvokerConfig {
	@Autowired
	SingerService singerService;

	@Bean(name = "/httpInvoker/singerService")
	public HttpInvokerServiceExporter httpInvokerServiceExporter() {
		HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
		invokerService.setService(singerService);
		invokerService.setServiceInterface(SingerService.class);
		return invokerService;
	}
}
