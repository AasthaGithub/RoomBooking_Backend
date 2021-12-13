# RoomBooking_Backend
SpringBoot Backend Application for managing hotel room bookings along with Billing Payments for users &amp; CRUD on rooms of hotel for Admin

## Functionalities
```
1. For Users : 
	- Register/ Login, 
	- Check availability for rooms, 
	- Book 1 or multiple rooms for a date, 
	- Get Bill/ Payment Details for all bookings.
2. For Admin : Add/Delete rooms, Update room bookings.
```

## Controller/ API Endpoints
- Admin : ```/hotel-rooms/admin``` 	(Only for authenticated high priveleged Admins)
- User : ```/hotel-rooms/v1```	(Public API for logged in users)