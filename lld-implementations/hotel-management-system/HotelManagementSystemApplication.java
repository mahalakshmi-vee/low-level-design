package com.practice.hotel_management_system;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);

		HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();

		Room singleRoom1 = new Room("1", RoomType.SINGLE, 2500, RoomStatus.AVAILABLE);
		Room singleRoom2 = new Room("2", RoomType.SINGLE, 3000, RoomStatus.AVAILABLE);
		hotelManagementSystem.addRoom(singleRoom1);
		hotelManagementSystem.addRoom(singleRoom2);

		Guest maha = new Guest("1", "Maha", "0123456789", "test@gmail.com");
		hotelManagementSystem.addGuest(maha);

		Reservation reservation = hotelManagementSystem.bookRoom(maha, singleRoom1, LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(3));
		System.out.println(reservation.getId());

		hotelManagementSystem.checkIn(reservation.getId());
		System.out.println("Checked in: " + reservation.getId());

		Payment payment = new CreditCardPayment();
		hotelManagementSystem.checkOut(reservation.getId(), payment);
		System.out.println("Checked out: " + reservation.getId());

		hotelManagementSystem.cancelReservation(reservation.getId());
		System.out.println("Reservation cancelled: " + reservation.getId());
	}

}
