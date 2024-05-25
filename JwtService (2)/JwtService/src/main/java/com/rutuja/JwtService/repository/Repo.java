package com.rutuja.JwtService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.JwtService.entity.MyUser;

@Repository
public interface Repo extends JpaRepository<MyUser, Integer>{

	Optional<MyUser> findByName(String username);

}
