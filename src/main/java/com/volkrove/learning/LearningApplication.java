package com.volkrove.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@SpringBootApplication(exclude={DockerCompose.class})
@SpringBootApplication()
@EnableAsync
@EnableScheduling
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);

		System.out.println("did the thing");
	}


}
