package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;

public interface RestaurantListService {
	
	List<Restaurant> findByNameWildcard(RestaurantSearchForm form);
	
}
