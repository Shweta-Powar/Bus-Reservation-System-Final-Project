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
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Passenger_name")
	private String pname;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Total_seats")
	private int totalseats;
	
	@Column(name="SeatNo")
	private int seatno;
	
	@Column(name="Booked_date")
	private String bdate;
	
	@Column(name="Payment_Status")
	private String payment_status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", pname=" + pname + ", destination=" + destination + ", totalseats=" + totalseats
				+ ", seatno=" + seatno + ", bdate=" + bdate + ", payment_status=" + payment_status + "]";
	}
	
	
	

   
		
	
}