package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.bean.Rooms;
import com.booking.dao.RoomsDao;
@Service
public class RoomsServiceImpl implements RoomsService {

	@Autowired
	private RoomsDao roomsDao;

	@Override
	public Rooms findRoomDetailsById(Integer id) {
		System.out.println("userid" + id);
		return roomsDao.findByRoomId(id);
	}

	@Override
	public Rooms saveRoom(Rooms room) {
		System.out.println("room" + room);
		return roomsDao.save(room);
	}

	@Override
	public List<Rooms> getAllRooms() {
		return roomsDao.getAllRooms();
	}

	@Override
	public Double findRoomPrice(Integer roomid) {
		return roomsDao.findPricePerDayByRoomId(roomid);
	}
	

}
