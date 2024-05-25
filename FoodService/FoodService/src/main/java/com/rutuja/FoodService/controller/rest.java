package com.rutuja.FoodService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.FoodService.entity.Food;
import com.rutuja.FoodService.repository.Repo;

@RestController
@RequestMapping("/food")
public class rest {

	@Autowired
	private Repo repo;
	
	@PostMapping("/save")
	public Food saveFood(@RequestBody Food food) {
		return repo.save(food);
	}
	
	@GetMapping("/all")
	public List<Food> getAllFood(){
		return repo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Food getById(@PathVariable int id) {
		Optional<Food> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/findByHotel/{id}")
	public List<Food> getByHotel(@PathVariable int id){
		return repo.findByHotelid(id);
	}
} 
