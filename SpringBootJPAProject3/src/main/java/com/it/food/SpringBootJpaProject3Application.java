package com.it.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.food.controller"})
public class SpringBootJpaProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject3Application.class, args);
	}

}
