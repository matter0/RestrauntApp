package com.restraunt.restrauntApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.restraunt.restrauntApp")
@EntityScan(basePackages = "com.restraunt.restrauntApp.domain")
@EnableAutoConfiguration
public class RestrauntAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestrauntAppApplication.class, args);
		System.out.println("started application");
	}

}
