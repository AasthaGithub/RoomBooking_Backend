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

@Entity
@Table(name = "room_booking")
public class RoomBookings {

	@Id
	@Column(name = "booking_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomBookingNo;

	@Column(name = "booking_date")
	private String bookingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private Rooms room;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private Bookings booking;

	public int getRoomBookingNo() {
		return roomBookingNo;
	}

	public void setRoomBookingNo(int roomBookingNo) {
		this.roomBookingNo = roomBookingNo;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public RoomBookings(int roomBookingNo, String bookingDate, Rooms room, Bookings booking) {
		super();
		this.roomBookingNo = roomBookingNo;
		this.bookingDate = bookingDate;
		this.room = room;
		this.booking = booking;
	}

	public RoomBookings() {
		super();
	}

	@Override
	public String toString() {
		return "RoomBookings [roomBookingNo=" + roomBookingNo + ", bookingDate=" + bookingDate + ", room=" + room
				+ ", booking=" + booking + "]";
	}

}
