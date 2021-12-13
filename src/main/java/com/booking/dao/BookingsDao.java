package com.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booking.bean.Bookings;

public interface BookingsDao extends JpaRepository<Bookings, Integer> {

	Bookings findBybookingId(Integer bookingsId);

	@Query(value = "SELECT * FROM bookings where room_id = :roomId", nativeQuery = true)
	List<Bookings> findBookingByRoomID(@Param("roomId") String roomId);

	@Query(value = "SELECT sum(amount) FROM bookings", nativeQuery = true)
	Double calculateRevenue();

}
