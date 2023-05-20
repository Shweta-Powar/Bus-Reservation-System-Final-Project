package com.example.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Admin;
import com.example.springboot.repository.AdminRepository;
import com.example.springboot.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	private AdminRepository adminRepository;
	
	
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}



	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}



	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}



	@Override
	public Admin getAdminById(long uid) {
		
		return adminRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("Admin","Id",uid));
	}



	@Override
	public Admin updateAdmin(Admin admin, long uid) {
		// TODO Auto-generated method stub
		Admin existingAdmin=adminRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("Admin","Id",uid));
		existingAdmin.setFirstname(admin.getFirstname());
		existingAdmin.setLastname(admin.getLastname());
		existingAdmin.setContact(admin.getContact());
		existingAdmin.setEmail(admin.getEmail());
		existingAdmin.setPassword(admin.getPassword());
		existingAdmin.setRole(admin.getRole());
		adminRepository.save(existingAdmin);
		return existingAdmin;
	}



	@Override
	public void deleteAdmin(long uid) {
		// TODO Auto-generated method stub
		adminRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("Admin","Id",uid));
		adminRepository.deleteById(uid);
		
	}
	
}
