package com.demo.restaurants.demo;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.restaurants.demo.utils.RestaurantParser;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private RestaurantParser restaurantParser; 

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
	}
	public void run(String... args) throws FileNotFoundException {
		//restaurantParser.parseCsv();
    }

}
