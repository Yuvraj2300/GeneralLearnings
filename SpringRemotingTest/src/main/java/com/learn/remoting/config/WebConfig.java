package com.learn.remoting.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@EnableJpaAuditing
@ComponentScan(basePackages = { "com.learn.remoting"})
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	ApplicationContext ctx;
	
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
		return mappingJackson2HttpMessageConverter;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		objMapper.setDateFormat(df);
		return objMapper;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
	//	converters.add(singerMessageConverter());
	}

	@Bean
	MarshallingHttpMessageConverter singerMessageConverter() {
		MarshallingHttpMessageConverter mc = new MarshallingHttpMessageConverter();
	/*	mc.setMarshaller(castorMarshaller());
		mc.setUnmarshaller(castorMarshaller());*/
		List<MediaType> mediaTypes = new ArrayList<>();
		MediaType mt = new MediaType("application", "json");
		mediaTypes.add(mt);
		mc.setSupportedMediaTypes(mediaTypes);
		return mc;
	}
/*
	@SuppressWarnings("deprecation")
	@Bean
	CastorMarshaller castorMarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		castorMarshaller.setMappingLocation(ctx.getResource("classpath:spring/oxm-mapping.xml"));
		return castorMarshaller;
	}
*/}
