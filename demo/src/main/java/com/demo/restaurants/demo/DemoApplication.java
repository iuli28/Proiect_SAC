package com.demo.restaurants.demo;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.restaurants.demo.utils.ManhattenDistanceSimilarityExample;
import com.demo.restaurants.demo.utils.RestaurantParser;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {
	
	@Autowired
	private RestaurantParser restaurantParser; 
	
	@Autowired
	private ManhattenDistanceSimilarityExample manhattenDistanceSimilarityExample; 
	

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
	}
	
	public void run(String... args) throws FileNotFoundException {
		System.out.println("rules");
		manhattenDistanceSimilarityExample.runPrediciton();
    }

}
