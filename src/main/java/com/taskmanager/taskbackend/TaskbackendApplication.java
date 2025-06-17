package com.taskmanager.taskbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TaskbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskbackendApplication.class, args);
	}

}
