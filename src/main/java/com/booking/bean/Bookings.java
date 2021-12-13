package com.booking.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bookings")
public class Bookings {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="billdate")
	private String billdate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Rooms room;

	public Bookings() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billingdate) {
		this.billdate = billingdate;
	}

	public Bookings(int bookingId, double amount, String billdate, Rooms room) {
		super();
		this.bookingId = bookingId;
		this.amount = amount;
		this.billdate = billdate;
		this.room = room;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", amount=" + amount + ", billdate=" + billdate + ", room=" + room
				+ "]";
	}

	

	
	
	
}
