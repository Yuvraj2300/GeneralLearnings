package com.learn.validation;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

public class StringToDateTimeConverter implements	Converter<String,DateTime>{

	private	static	final	String	DEFUALT_DATE_PATTERN	=	"yyyy-MM-dd";
	private	DateTimeFormatter	dateFormat;
	
	private	String	datePattern	=	DEFUALT_DATE_PATTERN;
		
	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@PostConstruct
	public	void	init() {
		dateFormat	=	DateTimeFormat.forPattern(datePattern);
	}
	
	@Override
	public DateTime convert(String source) {
		// TODO Auto-generated method stub
		return dateFormat.parseDateTime(source);
	}
}
