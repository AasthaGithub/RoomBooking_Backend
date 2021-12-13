package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.bean.Rooms;
import com.booking.services.RoomsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotel-rooms/admin/")
public class AdminController {

	@Autowired
	private RoomsServiceImpl roomsService;

	// --------------------- Rooms CRUD for Admin -------------------------------

	@GetMapping("/rooms/{roomid}")
	public Rooms findroomById(@PathVariable("roomid") int roomid) {
		System.out.println("roomid " + roomid);
		return roomsService.findRoomDetailsById(roomid);
	}

	@PostMapping("/saveRoom")
	public Rooms saveRoom(@RequestBody Rooms room) {
		return roomsService.saveRoom(room);
	}

	@PostMapping("/updateRoom")
	public Rooms updateRoom(@RequestBody Rooms room) {
		System.out.println("room " + room);
		return roomsService.saveRoom(room);
	}

	@GetMapping("/rooms")
	public List<Rooms> getAllRooms() {
		return roomsService.getAllRooms();
	}
}
