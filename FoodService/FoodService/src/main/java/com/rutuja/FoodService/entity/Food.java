package com.rutuja.FoodService.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String foodname;
	private int price;
	private int hotelid;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Food(int id, String foodname, int price, int hotelid) {
		super();
		this.id = id;
		this.foodname = foodname;
		this.price = price;
		this.hotelid = hotelid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodname=" + foodname + ", price=" + price + ", hotelid=" + hotelid + "]";
	}
		
}
