package com.example.springboot.service;

import java.util.List;


import com.example.springboot.model.Passenger;

public interface PassengerService {
	Passenger savePassenger(Passenger passenger);
	List<Passenger> getAllPassenger();
	Passenger getPassengerById(long uid);
	Passenger updatePassenger(Passenger passenger, long uid);
	void deletePassenger(long uid);
}
