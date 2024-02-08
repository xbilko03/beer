package com.bilko.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeerApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(BeerApplication.class, args);
	}
   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
}
