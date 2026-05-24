package com.example.practice.guvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableJpaRepositories({"com.example.practice.guvi.repository.mysql", "com.example.practice.guvi.repository.h2"})
@EnableMongoRepositories("com.example.practice.guvi.repository.mongodb")
@SpringBootApplication
@EnableWebMvc
public class GuviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuviApplication.class, args);
	}

}
