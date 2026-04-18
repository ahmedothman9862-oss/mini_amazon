package com.example.MiniAmazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiniAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniAmazonApplication.class, args);
	}

}
