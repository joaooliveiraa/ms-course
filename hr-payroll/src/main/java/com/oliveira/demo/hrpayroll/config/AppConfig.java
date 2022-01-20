package com.oliveira.demo.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	//Singleton, criado o objeto template para pode injetar em outros serviços
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
