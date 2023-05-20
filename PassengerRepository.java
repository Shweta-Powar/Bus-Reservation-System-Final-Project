package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
