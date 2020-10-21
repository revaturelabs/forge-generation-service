package com.forge.PortfolioGenerationService;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class PortfolioGenerationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioGenerationServiceApplication.class, args);
	}
	
	

}
