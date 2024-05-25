package com.rutuja.HotelService.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Component
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hotelname;
	@Transient
	private List<Food> foods;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hotel(int id, String hotelname, List<Food> foods) {
		super();
		this.id = id;
		this.hotelname = hotelname;
		this.foods = foods;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelname=" + hotelname + ", foods=" + foods + "]";
	}
	
	
}
