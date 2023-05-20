package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long>{

}
