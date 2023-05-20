package com.example.springboot.service;

import java.util.List;


import com.example.springboot.model.User;

public interface UserService {
	//User getUserByEmail(String email);
	User  saveUser(User user);
	List<User> getAllUser();
	User getUserById(long uid);
	User updateUser(User user, long uid);
	void deleteUser(long uid);
}

