package com.rutuja.JwtService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rutuja.JwtService.entity.MyUser;
import com.rutuja.JwtService.repository.Repo;

@Service
public class MyUserService implements UserDetailsService{

	@Autowired
	private Repo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> optional=repo.findByName(username);
		if(optional.isPresent()) {
			return optional.map(MyUserDetails::new).get();
		}
	return null;
	}

	public String register(MyUser myUser) {
		myUser.setPasscode(passwordEncoder.encode(myUser.getPasscode()));
		repo.save(myUser);
		return "User Successfully Resgisterd .....";
	}
}
