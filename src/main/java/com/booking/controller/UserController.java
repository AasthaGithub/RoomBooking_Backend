package com.booking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.bean.BookRequest;
import com.booking.bean.Bookings;
import com.booking.bean.RoomBookings;
import com.booking.bean.UserDetails;
import com.booking.bean.UserLogin;
import com.booking.services.BookingsServiceImpl;
import com.booking.services.RoomBookingsServiceImpl;
import com.booking.services.RoomsServiceImpl;
import com.booking.services.UserDetailsServiceImpl;
import com.booking.services.UserLoginServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotel-rooms/v1")
public class UserController {

	@Autowired
	private RoomBookingsServiceImpl roomBookingsService;
	@Autowired
	private RoomsServiceImpl roomsService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private BookingsServiceImpl bookingsService;
	@Autowired
	private UserLoginServiceImpl userLoginService;

	// ----------------http://localhost:8081//hotel-rooms/v1 -------------------

	// --------------------- Single Booking-------------------------------------

	@PostMapping("/book/{roomid}/{bookingdate}")
	public RoomBookings bookARoom(@RequestBody RoomBookings userPolicy, @PathVariable("roomid") int roomid,
			@PathVariable("date") String bookingdate) {
		if (roomBookingsService.isRoomAvailable(roomid, bookingdate)) {
			double amount = roomsService.findRoomPrice(roomid);
			String billdate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			Bookings b = bookingsService.addBooking(roomid, billdate, amount);
			int bookingId = b.getBookingId();
			return roomBookingsService.addRoomBookings(roomid, bookingId, bookingdate);
		}
		return null;
	}

	// --------------------- Multiple Bookings----------------------------------

	@PostMapping("/book")
	public List<RoomBookings> bookRooms(@RequestBody List<BookRequest> bookRequestArray) {
		double totalBillPayable = 0;
		List<RoomBookings> res = new ArrayList<RoomBookings>();
		for (BookRequest req : bookRequestArray) {
			int roomid = req.getRoomid();
			String bookingdate = req.getBookingDate();

			if (roomBookingsService.isRoomAvailable(roomid, bookingdate)) {
				double amount = roomsService.findRoomPrice(roomid);
				String billdate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				Bookings b = bookingsService.addBooking(roomid, billdate, amount);
				int bookingId = b.getBookingId();
				totalBillPayable += b.getAmount();
				res.add(roomBookingsService.addRoomBookings(roomid, bookingId, bookingdate));
			}
		}
		System.out.println(totalBillPayable);
		return res;
	}

	// ------------------UserDetails-------------------------------------------

	@GetMapping("/userDetsById/{userid}")
	public UserDetails findUserDetailsById(@PathVariable("userid") int userid) {

		System.out.println("UserId " + userid);
		return userDetailsService.findUserDetailsById(userid);
	}

	@PostMapping("/saveUser")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {

		System.out.println("UserDetails " + userDetails);
		return userDetailsService.saveUser(userDetails);
	}

	@PostMapping("/updateUser")
	public UserDetails updateUser(@RequestBody UserDetails userDetails) {

		System.out.println("UserDetails " + userDetails);
		return userDetailsService.saveUser(userDetails);
	}

	// -----------------UserLogin----------------------------------------------
	@PostMapping("/saveUserLoginCreds/{userid}")
	public UserLogin saveLoginCreds(@RequestBody UserLogin user, @PathVariable("userid") int userid) {

		System.out.println("LoginCreds " + user);
		return userLoginService.saveUser(user, userid);
	}

	@GetMapping("/getPwdByEmail/{emailid}")
	public UserLogin findLoginCreds(@PathVariable("emailid") String emailid) {

		System.out.println("emailId " + emailid);
		return userLoginService.fetchLoginUser(emailid);
	}

}
