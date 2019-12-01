package com.demo.restaurants.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.restaurants.demo.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
