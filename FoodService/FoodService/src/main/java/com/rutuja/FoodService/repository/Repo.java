package com.rutuja.FoodService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.FoodService.entity.Food;

@Repository
public interface Repo extends JpaRepository<Food, Integer>{

	List<Food> findByHotelid(int id);;
}
