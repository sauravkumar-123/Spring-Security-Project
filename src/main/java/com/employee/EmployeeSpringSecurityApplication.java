package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeSpringSecurityApplication {

	public static void main(String[] args) {
		System.out.println("Application Started......");
		SpringApplication.run(EmployeeSpringSecurityApplication.class, args);
	}

}
