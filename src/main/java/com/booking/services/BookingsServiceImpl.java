package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.bean.Bookings;
import com.booking.dao.BookingsDao;
import com.booking.dao.RoomsDao;

@Service
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	private BookingsDao bookingsDao;
	@Autowired
	private RoomsDao roomsDao;

	@Override
	public List<Bookings> getBookingsByRoomId(String id) {
		return bookingsDao.findBookingByRoomID(id);
	}

	@Override
	public double getTotalRevenue() {
		return bookingsDao.calculateRevenue();
	}

	@Override
	public Bookings addBooking(int roomid, String billingdate, double amount) {
		Bookings b = new Bookings();
		b.setRoom(roomsDao.findByRoomId(roomid));
		b.setAmount(amount);
		b.setBilldate(billingdate);
		return bookingsDao.save(b);
	}

}
