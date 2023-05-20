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

import com.example.springboot.model.Passenger;
import com.example.springboot.service.PassengerService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/passengers/
@RequestMapping("/api/passengers/")
public class PassengerController {

	private PassengerService passengerService;

	public PassengerController(PassengerService passengerService) {
		super();
		this.passengerService = passengerService;
	}
	//http://localhost:8089/api/passengers
	@PostMapping
	public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger)
	{
		System.out.println(passenger);
		return new ResponseEntity<Passenger>(passengerService.savePassenger(passenger),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/passengers
	@GetMapping
	public List<Passenger> getAllPassenger()
	{
		return passengerService.getAllPassenger();
	}
	//http://localhost:8089/api/passengers/2
	@GetMapping("{uid}")
	public ResponseEntity<Passenger> getPassengerById(@PathVariable("uid") long passengerId)
	{
		return new ResponseEntity<Passenger>(passengerService.getPassengerById(passengerId),HttpStatus.OK);
	}
	//http://localhost:8089/api/passengers/2
	@PutMapping("{uid}")
	public ResponseEntity<Passenger> updatePassenger(@PathVariable("uid") long uid, @RequestBody Passenger passenger)
	{
		return new ResponseEntity<Passenger> (passengerService.updatePassenger(passenger, uid),HttpStatus.OK);
	}
	//http://localhist:8089/api/passengers/6
	@DeleteMapping("{uid}")
	public ResponseEntity<String> deletePassenger(@PathVariable("uid") long uid)
	{
		passengerService.deletePassenger(uid);
		return new ResponseEntity<String>("Passenger deleted successfully",HttpStatus.OK);
	}
}