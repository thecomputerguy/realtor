package com.realtor.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
@EnableWebSecurity
@EnableMethodSecurity
public class RealtorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtorApplication.class, args);
	}

}
