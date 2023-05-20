package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Bus;

public interface BusService {
	Bus saveBus(Bus bus);
	List<Bus> getAllBuses();
	Bus getBusById(long bid);
	Bus updateBus(Bus bus, long bid);
	void deleteBus(long bid);
	
}
