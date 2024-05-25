package com.rutuja.HotelService.feignComm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rutuja.HotelService.entity.Food;

@FeignClient(name="FoodService")
public interface Feign {

	@GetMapping("/food/all")
	public List<Food> getAllFood();
	
	@GetMapping("/food/findById/{id}")
	public Food getById(@PathVariable int id);
	
	@GetMapping("/food/findByHotel/{id}")
	public List<Food> getByHotel(@PathVariable int id);
}
