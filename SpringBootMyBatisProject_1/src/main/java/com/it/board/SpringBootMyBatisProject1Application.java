package com.it.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.it.board.controller",
		"com.it.board.service","com.it.board.dao"})
public class SpringBootMyBatisProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisProject1Application.class, args);
	}

}
