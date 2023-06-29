package com.stockexchange.stockecmarker;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockecmarkerApplication {

	Logger logger = LoggerFactory.getLogger(StockecmarkerApplication.class);


	@PostConstruct
	public void init(){
		logger.info("Application started ");

	}
	public static void main(String[] args) {
		SpringApplication.run(StockecmarkerApplication.class, args);
	}

}
