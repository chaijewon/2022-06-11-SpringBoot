package com.it.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.food.dao",
		"com.it.food.contoller","com.it.food.entity"})
public class SpringBootJpaProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProject2Application.class, args);
	}

}
