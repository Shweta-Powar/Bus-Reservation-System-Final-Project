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

import com.example.springboot.model.Bus;
import com.example.springboot.service.BusService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/buses/
@RequestMapping("/api/buses/")
public class BusController {

	private BusService busService;

	public BusController(BusService busService) {
		super();
		this.busService = busService;
	}
	//http://localhost:8089/api/buses
	@PostMapping
	public ResponseEntity<Bus> saveBus(@RequestBody Bus bus)
	{
		System.out.println(bus);
		return new ResponseEntity<Bus>(busService.saveBus(bus),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/buses
	@GetMapping
	public List<Bus> getAllBus()
	{
		return busService.getAllBuses();
	}
	//http://localhost:8089/api/buses/2
	@GetMapping("{bid}")
	public ResponseEntity<Bus> getBusById(@PathVariable("bid") long busId)
	{
		return new ResponseEntity<Bus>(busService.getBusById(busId),HttpStatus.OK);
	}
	//http://localhost:8089/api/buses/2
	@PutMapping("{bid}")
	public ResponseEntity<Bus> updateBus(@PathVariable("bid") long bid, @RequestBody Bus bus)
	{
		return new ResponseEntity<Bus> (busService.updateBus(bus, bid),HttpStatus.OK);
	}
	//http://localhist:8089/api/buses/6
	@DeleteMapping("{bid}")
	public ResponseEntity<String> deleteBus(@PathVariable("bid") long bid)
	{
		busService.deleteBus(bid);
		return new ResponseEntity<String>("Bus deleted successfully",HttpStatus.OK);
	}
}