CREATE DATABASE hoteldb;
USE hoteldb;

CREATE TABLE user_details
(
user_id int primary key AUTO_INCREMENT,
username varchar(50),
email varchar(50),
mobileno varchar(50)
)

CREATE TABLE user_login
(
email varchar(50),
password varchar(50),
user_id int references user_details(user_id)
);

CREATE TABLE rooms
(
room_id int primary key AUTO_INCREMENT,
price_per_day int
)

CREATE TABLE bookings
(		
booking_id int primary key NOT NULL AUTO_INCREMENT,		
billdate varchar(50),
amount bigint,		

room_id int references rooms(room_id)
)AUTO_INCREMENT=10;

CREATE TABLE room_booking
(		
booking_no int primary key NOT NULL AUTO_INCREMENT,		
booking_date varchar(50),		

room_id int references rooms(room_id),

booking_id int references bookings(booking_id)
)AUTO_INCREMENT=20;