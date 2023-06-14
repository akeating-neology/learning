package com.volkrove.learning;

import com.volkrove.learning.runnable.MSOAPthread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(exclude={DockerCompose.class})
@SpringBootApplication()
@EnableAsync
@EnableScheduling
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);

		System.out.println("did the thing");

		MSOAPthread mt = new MSOAPthread();
		mt.someAsyncMethod();
	}


}
