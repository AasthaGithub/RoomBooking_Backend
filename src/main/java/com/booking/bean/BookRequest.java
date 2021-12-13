package com.booking.bean;

public class BookRequest {

	int roomid;
	String bookingDate;
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "BookRequest [roomid=" + roomid + ", bookingDate=" + bookingDate + "]";
	}
	public BookRequest(int roomid, String bookingDate) {
		super();
		this.roomid = roomid;
		this.bookingDate = bookingDate;
	}
	public BookRequest() {
		super();
	}
	
	
}
