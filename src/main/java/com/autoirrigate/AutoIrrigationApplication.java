package com.autoirrigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRetry
public class AutoIrrigationApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AutoIrrigationApplication.class);
		springApplication.run(args);
	}

}
