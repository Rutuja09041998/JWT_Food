package com.rutuja.JwtService.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String passcode;
	private String role;
	
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyUser(int id, String name, String passcode, String role) {
		super();
		this.id = id;
		this.name = name;
		this.passcode = passcode;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", name=" + name + ", passcode=" + passcode + ", role=" + role + "]";
	}
	
}
