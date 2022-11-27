package com.sas.studentclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class StudentClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentClientApplication.class, args);
	}

}
