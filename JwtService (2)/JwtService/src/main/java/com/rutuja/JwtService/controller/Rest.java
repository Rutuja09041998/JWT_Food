package com.rutuja.JwtService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.JwtService.entity.LoginRequest;
import com.rutuja.JwtService.entity.MyUser;
import com.rutuja.JwtService.service.JWTService;
import com.rutuja.JwtService.service.MyUserService;

@RestController
@RequestMapping("/rutuja")
public class Rest {

	@Autowired
	private MyUserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;
	
	@PostMapping("/register")
	public String register(@RequestBody MyUser myUser) {
		return service.register(myUser);
	}
	
	@PostMapping("/token")
	public String genrateToken(@RequestBody LoginRequest loginRequest) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPasscode()));
		if(authentication.isAuthenticated()) {
			return jwtService.GenratedToken(loginRequest.getName());
		}
		return "Wrong Username Or Password .....";
	}
	
	@GetMapping("/valid")
	public String Valied(@RequestParam String token) {
		jwtService.Extractallclaims(token);
		return "Token is valid.....";
		}
}
