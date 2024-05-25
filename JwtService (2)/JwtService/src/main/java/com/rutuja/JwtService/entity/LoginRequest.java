package com.rutuja.JwtService.entity;

public class LoginRequest {

	private String name;
	private String passcode;
	
	public LoginRequest(String name, String passcode) {
		super();
		this.name = name;
		this.passcode = passcode;
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "LoginRequest [name=" + name + ", passcode=" + passcode + "]";
	}
	
	
}
