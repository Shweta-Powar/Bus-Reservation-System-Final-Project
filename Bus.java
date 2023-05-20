package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import lombok.Data;

//@Data
@Entity
@Table(name="Bus")
public class Bus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bid;
	
	@Column(name="Bus_name")
	private String busname;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="total_seats")
	private int totalseats;
	
	@Column(name="ticket_prize")
	private int ticket_prize;
	
	@Column(name="Bus_time")
	private String time;
	
	

	public long getBid() {
		return bid;
	}



	public void setBid(long bid) {
		this.bid = bid;
	}



	public String getBusname() {
		return busname;
	}



	public void setBusname(String busname) {
		this.busname = busname;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public int getTotalseats() {
		return totalseats;
	}



	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}



	public int getTicket_prize() {
		return ticket_prize;
	}



	public void setTicket_prize(int ticket_prize) {
		this.ticket_prize = ticket_prize;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", busname=" + busname + ", destination=" + destination + ", totalseats="
				+ totalseats + ", ticket_prize=" + ticket_prize + ", time=" + time + "]";
	}
	

   
		
	
}