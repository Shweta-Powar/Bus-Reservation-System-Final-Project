package com.example.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
