package com.demo.restaurants.demo;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.restaurants.demo.utils.RestaurantParser;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		
		RestaurantParser parser = new RestaurantParser();
		parser.parseCsv();
	}

}
