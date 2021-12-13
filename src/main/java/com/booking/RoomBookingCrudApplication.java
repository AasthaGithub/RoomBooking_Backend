package com.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomBookingCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingCrudApplication.class, args);
		System.out.print("Application Running");
	}

}
