package com.example.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/admins/
@RequestMapping("/api/users/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
//	 @PostMapping("/register")
//	    public ResponseEntity<String> register(@RequestBody User user) {
//	        if (userService.getUserByEmail(user.getEmail()) != null) {
//	            return ResponseEntity.badRequest().body("Username already exists");
//	        }
//
//	        // TODO: Perform any additional validation and save the user
//	        userService.saveUser(user);
//	        return ResponseEntity.ok("Registration successful");
//	    }
//	 @PostMapping("/login")
//	    public ResponseEntity<String> login(@RequestBody User user) {
//	        User existingUser = userService.getUserByEmail(user.getEmail());
//	        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//	        }
//
//	        // TODO: Generate and return an authentication token
//	        return ResponseEntity.ok("Login successful");
//	    }
//	
	
	//http://localhost:8089/api/users
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		System.out.println(user);
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/admins
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	//http://localhost:8089/api/admins/2
	@GetMapping("{uid}")
	public ResponseEntity<User> getUserById(@PathVariable("uid") long userId)
	{
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	//http://localhost:8089/api/admins/2
	@PutMapping("{uid}")
	public ResponseEntity<User> updateUser(@PathVariable("uid") long uid, @RequestBody User user)
	{
		return new ResponseEntity<User> (userService.updateUser(user, uid),HttpStatus.OK);
	}
	//http://localhist:8089/api/admins/6
	@DeleteMapping("{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") long uid)
	{
		userService.deleteUser(uid);
		return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
	}
}