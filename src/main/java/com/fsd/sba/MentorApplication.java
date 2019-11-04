package com.fsd.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MentorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MentorApplication.class, args);
	}
}