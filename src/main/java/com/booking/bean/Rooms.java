package com.booking.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {

	@Id
	@Column(name="room_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	
	@Column(name="price_per_day")
	private double pricePerDay;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Rooms(int roomId, double pricePerDay) {
		super();
		this.roomId = roomId;
		this.pricePerDay = pricePerDay;
	}

	public Rooms() {
		super();
	}

	@Override
	public String toString() {
		return "Rooms [roomId=" + roomId + ", pricePerDay=" + pricePerDay + "]";
	}
	
	
	
}
