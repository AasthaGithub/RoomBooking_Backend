package com.booking.services;

import java.util.List;

import com.booking.bean.Bookings;

public interface BookingsService {
	
	double getTotalRevenue();

	List<Bookings> getBookingsByRoomId(String id);

	Bookings addBooking(int roomid, String bookingdate, double amount);

}
