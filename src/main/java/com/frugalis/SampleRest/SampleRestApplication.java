package com.frugalis.SampleRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.frugalis")
@EnableJpaRepositories(basePackages="com.frugalis.repository")
@EntityScan(basePackages="com.frugalis.entity")
public class SampleRestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SampleRestApplication.class, args);
		
	}
}
