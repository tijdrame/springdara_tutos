package com.emard.productdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
	}

}
