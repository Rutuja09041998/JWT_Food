package com.rutuja.HotelService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.HotelService.entity.Food;
import com.rutuja.HotelService.entity.Hotel;
import com.rutuja.HotelService.feignComm.Feign;
import com.rutuja.HotelService.repository.Repo;

@RestController
@RequestMapping("/hotel")
public class rest {

	@Autowired
	private Repo repo;
	
	@Autowired
	private Feign feign;
	
	@PostMapping("/save")
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return repo.save(hotel);
	}
	
	@GetMapping("/all")
	public List<Hotel> getAllHotel(){
		List<Hotel> listHotel=repo.findAll();
		return listHotel.stream().map(Hotel->{
			List<Food> listFood=feign.getByHotel(Hotel.getId());
			Hotel.setFoods(listFood);
			return Hotel;
		}).toList();
	}
	
	@GetMapping("/getByHotelId/{id}")
	public Hotel getByHotelId(@PathVariable int id) {
		Optional<Hotel> optional=repo.findById(id);
		if(optional.isPresent()) {
			Hotel hotel=optional.get();
			List<Food> listFood=feign.getByHotel(id);
			hotel.setFoods(listFood);
			return hotel;
		}
		return null;
	}
}
