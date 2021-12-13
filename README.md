# RoomBooking_Backend
SpringBoot Backend Application for managing hotel room bookings
along with Billing Payments for users &amp; CRUD on rooms of hotel for Admin

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
```
1. Admin : /hotel-rooms/admin		(Only for authenticated high priveleged Admins)
	- "/rooms/{roomid}" : get room details by room id
	- "/saveRoom", "/updateRoom" : add/update rooms
	- "/rooms" : see all the details of rooms, booked & free
2. Hotel Staff : /hotel-rooms/v1	(Public API for logged in users & staff)
	- "/rooms/avl/{date}" : get all avl rooms
	- "/rooms/booked/{date}" : get rooms booked & avl for a particular date
	- "/check/bookings/{roomid}" : check all bookings for a particular room
	- "/room/{roomid}" : get room details by id
3. Users:
	- "/book/{roomid}/{bookingdate}" : single booking
	- "/book"(array of booking requests) : multiple booking - fail 1, fail all approach for now.
	- "/userDetsById/{userid}", save/update user details & credentials
```
### Future Scope:
1. Introduce waitlisting feature.
2. Complete, integrate payment & bill generation feature.
3. Improvise the booking strategy.
<small>
<br/><br/>(Even if there are no available rooms for a certain date, 
<br/>let the booking be completed for other dates & rooms, when partial booking input is true.
<br/>smart booking for consecutive days or nearby rooms)
</small>
