package com.greenbelly.metraz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MetrazApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetrazApplication.class, args);
	}

}
