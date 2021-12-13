package com.booking.services;

import java.util.List;

import com.booking.bean.RoomBookings;

public interface RoomBookingsService {

	List<RoomBookings> findRoomBookingsByRoomId(Integer id);

	boolean isRoomAvailable(Integer roomId, String date);

	RoomBookings addRoomBookings(Integer roomId, Integer bookingId, String date);

	List<RoomBookings> getBookedRooms(String date);

}
