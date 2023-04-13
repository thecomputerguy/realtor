package com.realtor.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class RealtorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtorApplication.class, args);
	}

}
