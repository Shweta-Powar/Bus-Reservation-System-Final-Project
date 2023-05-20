package com.example.springboot.service.impl;

import java.util.List;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Booking;
import com.example.springboot.repository.BookingRepository;
import com.example.springboot.service.BookingService;

public class BookingServiceImpl implements BookingService{
private BookingRepository bookingRepository;
	
	
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}



	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}



	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}



	@Override
	public Booking getBookingById(long id) {
		
		return bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking","Id",id));
	}



	@Override
	public Booking updateBooking(Booking booking, long id) {
		// TODO Auto-generated method stub
		Booking existingBooking=bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking","Id",id));
		existingBooking.setPname(booking.getPname());
		existingBooking.setDestination(booking.getDestination());
		existingBooking.setTotalseats(booking.getTotalseats());
		existingBooking.setSeatno(booking.getSeatno());
		existingBooking.setBdate(booking.getBdate());
		existingBooking.setPayment_status(booking.getPayment_status());
		bookingRepository.save(existingBooking);
		return existingBooking;
	}



	@Override
	public void deleteBooking(long id) {
		// TODO Auto-generated method stub
		bookingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking","Id",id));
		bookingRepository.deleteById(id);
		
	}
	
}


