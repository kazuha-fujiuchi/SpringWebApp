package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RestaurantListServiceImpl implements RestaurantListService {
	
	private final RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> findByNameWildcard(RestaurantSearchForm form) {
		
		List<Restaurant> list = restaurantRepository.selectByNameWildcard(form);
		
		return list;
	}

}
