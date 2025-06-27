package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;

public interface RestaurantRepository {

	List<Restaurant> selectByNameWildcard(RestaurantSearchForm form);
}
