package com.Test.RestDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDbApplication.class, args);
	}
}
