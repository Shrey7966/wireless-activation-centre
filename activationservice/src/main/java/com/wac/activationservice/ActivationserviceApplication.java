package com.wac.activationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ActivationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivationserviceApplication.class, args);
	}

}
