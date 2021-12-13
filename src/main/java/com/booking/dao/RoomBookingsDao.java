package com.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booking.bean.RoomBookings;

public interface RoomBookingsDao  extends JpaRepository<RoomBookings, Integer>{
	
	@Query(value = "SELECT * FROM room_bookings where room_id = :roomID", nativeQuery = true)
	List<RoomBookings> findRoomBookingsByRoomId(@Param("roomID") Integer roomId);
	
	@Query(value = "SELECT * FROM room_bookings where booking_date = :date", nativeQuery = true)
	List<RoomBookings> findRoomBookingByDate(@Param("date") String date);

}
