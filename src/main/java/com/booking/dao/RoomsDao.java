package com.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.bean.Rooms;

public interface RoomsDao extends JpaRepository<Rooms, Integer> {

	Rooms findByRoomId(Integer id);
	
	@Query(value = "SELECT price_per_day FROM rooms where room_id = roomid", nativeQuery = true)
	Double findPricePerDayByRoomId(Integer roomid);
	
	@Query(value = "SELECT * FROM rooms", nativeQuery = true)
	List<Rooms> getAllRooms();
}
