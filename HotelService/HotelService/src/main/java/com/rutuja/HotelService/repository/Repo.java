package com.rutuja.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.HotelService.entity.Hotel;

@Repository
public interface Repo extends JpaRepository<Hotel, Integer>{

}
