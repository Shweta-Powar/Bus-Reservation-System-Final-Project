package com.example.springboot.service;

import java.util.List;


import com.example.springboot.model.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	List<Admin> getAllAdmin();
	Admin getAdminById(long uid);
	Admin updateAdmin(Admin admin, long uid);
	void deleteAdmin(long uid);
}

