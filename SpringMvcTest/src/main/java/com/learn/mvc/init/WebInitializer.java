package com.learn.mvc.init;


import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.learn.mvc.config.DataServiceConfig;
import com.learn.mvc.config.SecurityConfig;
import com.learn.mvc.config.WebConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { SecurityConfig.class, DataServiceConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		return new Filter[] { new HiddenHttpMethodFilter(), cef };
	}
	
	
	protected	void	customizeRegistration(ServletRegistration.Dynamic	registration) {
		registration.setMultipartConfig(getMultiPartConfigElement());
	}

	@Bean
	private MultipartConfigElement getMultiPartConfigElement() {
		// TODO Auto-generated method stub
		return new	MultipartConfigElement(null, 5000000, 5000000, 0);
	}
	
	

}
