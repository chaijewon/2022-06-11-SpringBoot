package com.it.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.board.dao",
		"com.it.board.controller",
		"com.it.board.entity"})
public class SpringBootJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProjectApplication.class, args);
	}

}
