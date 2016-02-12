package com.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemohApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemohApplication.class, args);
	}
	
	@Bean
	public ResourceConfig resourceConfig() {
		return new DemohResourceConfig();
	}
}
