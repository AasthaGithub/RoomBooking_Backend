package com.booking.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.bean.Bookings;
import com.booking.bean.RoomBookings;
import com.booking.bean.Rooms;
import com.booking.services.BookingsServiceImpl;
import com.booking.services.RoomBookingsServiceImpl;
import com.booking.services.RoomsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotel-rooms/v1")
public class HotelController {

	@Autowired
	private RoomBookingsServiceImpl roomBookingsService;
	@Autowired
	private BookingsServiceImpl bookingsService;
	@Autowired
	private RoomsServiceImpl roomsService;

	//	---------------Get Available Rooms- logic in service layer--------------

	@GetMapping("/rooms/avl/{date}")
	public List<Rooms> getAllAvailableRoomsForDate(@PathVariable("date") String date) {

		List<Rooms> avlRooms = new ArrayList<Rooms>();

		List<RoomBookings> bookedRooms = roomBookingsService.getBookedRooms(date);
		List<Rooms> allRooms = roomsService.getAllRooms();
		HashSet<Integer> bookedIds = new HashSet<Integer>();
		for (RoomBookings b : bookedRooms) {
			bookedIds.add(b.getRoom().getRoomId());
		}
		for (Rooms room : allRooms) {
			if (bookedIds.contains(room.getRoomId())) {
				avlRooms.add(room);
			}
		}
		return avlRooms;
	}

	//   ---------------Get Booked Rooms----------------------------------------

	@GetMapping("/rooms/booked/{date}")
	public List<RoomBookings> getAllBookedRoomsForDate(@PathVariable("date") String date) {
		return roomBookingsService.getBookedRooms(date);
	}

	//   -----------------Check BookingOfRoom (future for hotel)----------------

	@GetMapping("/check/bookings/{roomid}")
	public List<Bookings> findBookingsByRoomId(@PathVariable("roomid") String roomid) {
		System.out.println("roomid " + roomid);
		return bookingsService.getBookingsByRoomId(roomid);
	}

	//   ---------------Rooms---------------------------------------------------

	@GetMapping("/room/{roomid}")
	public List<RoomBookings> findRoomByRoomId(@PathVariable("roomid") int roomid) {

		System.out.println("RoomID " + roomid);
		return roomBookingsService.findRoomBookingsByRoomId(roomid);
	}
}
