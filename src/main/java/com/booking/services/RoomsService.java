package com.booking.services;

import java.util.List;

import com.booking.bean.Rooms;

public interface RoomsService {
	
	Rooms findRoomDetailsById(Integer id);

	Rooms saveRoom(Rooms room);

	List<Rooms> getAllRooms();

	Double findRoomPrice(Integer roomid);
}
