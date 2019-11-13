package com.bala.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.bala")
@EntityScan(basePackages="com.bala.model")
public class StateStreetApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateStreetApplication.class, args);
	}

}
