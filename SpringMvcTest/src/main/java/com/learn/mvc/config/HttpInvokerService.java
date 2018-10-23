package com.learn.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.learn.mvc.services.SingerService;

@Configuration
public class HttpInvokerService {

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
