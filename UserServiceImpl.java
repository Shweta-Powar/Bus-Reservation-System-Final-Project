package com.example.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}



	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}



	@Override
	public User getUserById(long uid) {
		
		return userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","Id",uid));
	}



	@Override
	public User updateUser(User user, long uid) {
		// TODO Auto-generated method stub
		User existingUser=userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","Id",uid));
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setContact(user.getContact());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setRole(user.getRole());
		userRepository.save(existingUser);
		return existingUser;
	}



	@Override
	public void deleteUser(long uid) {
		// TODO Auto-generated method stub
		userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","Id",uid));
		userRepository.deleteById(uid);
		
	}
	
}
