package com.example.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Passenger;
import com.example.springboot.repository.PassengerRepository;
import com.example.springboot.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	private PassengerRepository passengerRepository;

	public PassengerServiceImpl(PassengerRepository passengerRepository) {
		super();
		this.passengerRepository = passengerRepository;
	}

	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public List<Passenger> getAllPassenger() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger getPassengerById(long uid) {
//		Optional<Passenger> passenger = passengerRepository.findById(uid);
//		if(passenger.isPresent()) {
//			return passenger.get();
//	}else {
//		throw new ResourceNotFoundException("Passenger","Id",uid);
//	}
		return passengerRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("Passenger","Id",uid));
	}

	@Override
	public Passenger updatePassenger(Passenger passenger, long uid) {
		
		Passenger existingPassenger = passengerRepository.findById(uid).orElseThrow( () -> new ResourceNotFoundException("Passenger","Id",uid));
		existingPassenger.setFirstname(passenger.getFirstname());
		existingPassenger.setLastname(passenger.getLastname());
		existingPassenger.setContact(passenger.getContact());
		existingPassenger.setEmail(passenger.getEmail());
		existingPassenger.setPassword(passenger.getPassword());
		existingPassenger.setRole(passenger.getRole());
		passengerRepository.save(existingPassenger);
		return existingPassenger;
	}

	@Override
	public void deletePassenger(long uid) {
		
		passengerRepository.findById(uid).orElseThrow( () -> new ResourceNotFoundException("Passenger","Id",uid));
		passengerRepository.deleteById(uid);
		
		
	}
	
}
	
