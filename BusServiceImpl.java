package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;

import com.example.springboot.model.Bus;

import com.example.springboot.repository.BusRepository;
import com.example.springboot.service.BusService;

@Service
public class BusServiceImpl implements BusService {
  
private BusRepository busRepository;
	
	
	
	public BusServiceImpl(BusRepository busRepository) {
		super();
		this.busRepository = busRepository;
	}



	@Override
	public Bus saveBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}



	@Override
	public List<Bus> getAllBuses() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}



	@Override
	public Bus getBusById(long bid) {
		
		return busRepository.findById(bid).orElseThrow(()->new ResourceNotFoundException("Bus","Id",bid));
	}



	@Override
	public Bus updateBus(Bus bus, long bid) {
		// TODO Auto-generated method stub
		Bus existingBus=busRepository.findById(bid).orElseThrow(()->new ResourceNotFoundException("Bus","Id",bid));
		existingBus.setBusname(bus.getBusname());
		existingBus.setDestination(bus.getDestination());
		existingBus.setTotalseats(bus.getTotalseats());
		existingBus.setTicket_prize(bus.getTicket_prize());
		existingBus.setTime(bus.getTime());
		busRepository.save(existingBus);
		return existingBus;
	}



	@Override
	public void deleteBus(long bid) {
		// TODO Auto-generated method stub
		busRepository.findById(bid).orElseThrow(()->new ResourceNotFoundException("Bus","Id",bid));
		busRepository.deleteById(bid);
		
	}
	
}
