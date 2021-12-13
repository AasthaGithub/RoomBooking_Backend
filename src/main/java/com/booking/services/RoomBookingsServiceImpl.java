package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.bean.Bookings;
import com.booking.bean.RoomBookings;
import com.booking.bean.Rooms;
import com.booking.dao.BookingsDao;
import com.booking.dao.RoomBookingsDao;
import com.booking.dao.RoomsDao;

@Service
public class RoomBookingsServiceImpl implements RoomBookingsService {

	@Autowired
	private RoomBookingsDao roomBookingsDao;
	@Autowired
	private RoomsDao roomsDao;
	@Autowired
	private BookingsDao bookingsDao;

	@Override
	public List<RoomBookings> findRoomBookingsByRoomId(Integer id) {
		System.out.println("roomid" + id);
		return roomBookingsDao.findRoomBookingsByRoomId(id);
	}

	@Override
	public RoomBookings addRoomBookings(Integer roomId, Integer bookingId, String date) {
		RoomBookings roomBooking =  new RoomBookings();
		System.out.println("roomBooking" + roomBooking);
		System.out.println("roomId" + roomId);
		System.out.println("bookingId" + bookingId);

		Rooms fetchedRoom = roomsDao.findByRoomId(roomId);
		Bookings fetchedBooking = bookingsDao.findBybookingId(bookingId);
		
		roomBooking.setBookingDate(date);
		roomBooking.setBooking(fetchedBooking);
		roomBooking.setRoom(fetchedRoom);
		System.out.println("roomBooking updated" + roomBooking);

		return roomBookingsDao.save(roomBooking);
	}
	
	@Override
	public boolean isRoomAvailable(Integer roomId, String date) {
		List<RoomBookings> rooms = roomBookingsDao.findRoomBookingByDate(date);
		
		for(RoomBookings r: rooms) {
			if (r.getRoom().getRoomId() == roomId) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<RoomBookings> getBookedRooms(String date){
		return roomBookingsDao.findRoomBookingByDate(date);
	}
}
