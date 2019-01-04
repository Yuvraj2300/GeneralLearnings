package com.lrn.springrestex_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringRestEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestEx1Application.class, args);
	}

}

