package com.example.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Admin;
import com.example.springboot.service.AdminService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/admins/
@RequestMapping("/api/admins/")
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	//http://localhost:8089/api/admins
	@PostMapping
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin)
	{
		System.out.println(admin);
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/admins
	@GetMapping
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	//http://localhost:8089/api/admins/2
	@GetMapping("{uid}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("uid") long adminId)
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(adminId),HttpStatus.OK);
	}
	//http://localhost:8089/api/admins/2
	@PutMapping("{uid}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("uid") long uid, @RequestBody Admin admin)
	{
		return new ResponseEntity<Admin> (adminService.updateAdmin(admin, uid),HttpStatus.OK);
	}
	//http://localhist:8089/api/admins/6
	@DeleteMapping("{uid}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("uid") long uid)
	{
		adminService.deleteAdmin(uid);
		return new ResponseEntity<String>("Admin deleted successfully",HttpStatus.OK);
	}
}