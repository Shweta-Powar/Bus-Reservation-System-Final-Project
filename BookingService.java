package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Booking;

public interface BookingService {
	    Booking saveBooking(Booking booking);
		List<Booking> getAllBookings();
		Booking getBookingById(long id);
		Booking updateBooking(Booking booking, long id);
		void deleteBooking(long id);
	
}
