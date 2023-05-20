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

import com.example.springboot.model.Booking;
import com.example.springboot.service.BookingService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/bookings/
@RequestMapping("/api/bookings/")
public class BookingController {

	private BookingService bookingService;
	
	public BookingController( ) {
		
	}
	

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	//http://localhost:8089/api/bookings
	@PostMapping
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking)
	{
		System.out.println(booking);
		return new ResponseEntity<Booking>(bookingService.saveBooking(booking),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/bookings
	@GetMapping
	public List<Booking> getAllBooking()
	{
		return bookingService.getAllBookings();
	}
	//http://localhost:8089/api/bookings/2
	@GetMapping("{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") long bookingId)
	{
		return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId),HttpStatus.OK);
	}
	//http://localhost:8089/api/bookings/2
	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") long id, @RequestBody Booking booking)
	{
		return new ResponseEntity<Booking> (bookingService.updateBooking(booking, id),HttpStatus.OK);
	}
	//http://localhist:8089/api/bookings/6
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") long id)
	{
		bookingService.deleteBooking(id);
		return new ResponseEntity<String>("Booking canceled successfully",HttpStatus.OK);
	}
}