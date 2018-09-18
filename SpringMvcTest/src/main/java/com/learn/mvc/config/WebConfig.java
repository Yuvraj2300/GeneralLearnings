package com.learn.mvc.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.learn.mvc" })
public class WebConfig implements WebMvcConfigurer {

	// DECLARING THE STATIC RESOURCES
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/").setCachePeriod(31556926);
	}

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// resolver.setPrefix("/WEB-INF/views/");
		resolver.setPrefix("/views/");
		resolver.setSuffix(".jspx");
		resolver.setRequestContextAttribute("requestContext");
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("singers/list");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("i18n/messages", "i18n/application");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		localeChangeInterceptor();
	}

	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		//BOOK IS NOT SETTING THE CUSTOM PARAMETER.....
		LocaleChangeInterceptor	localeInterceptor	=	new	LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	@Bean
	CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		cookieLocaleResolver.setCookieMaxAge(3600);
		cookieLocaleResolver.setCookieName("locale");
		return cookieLocaleResolver;
	}

}
