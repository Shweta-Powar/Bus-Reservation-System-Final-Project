package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
