package com.practice.hotel_management_system;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Reservation {
	private final String id;
	private Guest guest;
	private Room room;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private ReservationStatus reservationStatus;

	public synchronized void cancelReservation() {
		if (reservationStatus == ReservationStatus.CONFIRMED) {
			reservationStatus = ReservationStatus.CANCELLED;
			room.checkOut();
		} else {
			throw new IllegalStateException("Reservation is not confirmed.");
		}
	}
}
