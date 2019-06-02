package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.repository.CarDetailsRepository;


@SpringBootApplication
@EnableJpaRepositories("com.repository")
@EntityScan(basePackages={"com.entity"})
public class CarDetailsBackendApplication {

	@Autowired
	CarDetailsRepository carDetailsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarDetailsBackendApplication.class, args);
	}

}
