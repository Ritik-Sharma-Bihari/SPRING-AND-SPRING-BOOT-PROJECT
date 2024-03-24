package com.blogapp.apis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	/*
	 * creating a method which has return types of ModelMapper
	 * to handle the converting one object to other 
	 */
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper(); 
	}

}
