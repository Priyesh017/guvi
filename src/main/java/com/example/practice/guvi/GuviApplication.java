package com.example.practice.guvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableJpaRepositories({"com.example.practice.guvi.repository.mysql", "com.example.practice.guvi.repository.h2"})
@EnableJpaRepositories("com.example.practice.guvi.repository.mysql")
@EnableMongoRepositories("com.example.practice.guvi.repository.mongodb")
@SpringBootApplication
public class GuviApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuviApplication.class, args);
	}

}
