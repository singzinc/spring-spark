package com.singplayground.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
@EnableCaching
//@ComponentScan
@ComponentScan(basePackages = { "com.singplayground.controller" })
public class Application extends SpringBootServletInitializer {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
