package com.practice.hotel_management_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Room {
	private final String id;
	private RoomType roomType;
	private double price;
	private RoomStatus roomStatus;

	public synchronized void bookRoom() {
		if (roomStatus == RoomStatus.AVAILABLE) {
			roomStatus = RoomStatus.BOOKED;
		} else {
			throw new IllegalStateException("Room is not available for booking.");
		}
	}

	public synchronized void checkIn() {
		if (roomStatus == RoomStatus.BOOKED) {
			roomStatus = RoomStatus.OCCUPIED;
		} else {
			throw new IllegalStateException("Room is not booked.");
		}
	}

	public synchronized void checkOut() {
		if (roomStatus == RoomStatus.OCCUPIED) {
			roomStatus = RoomStatus.AVAILABLE;
		} else {
			throw new IllegalStateException("Room is not occupied.");
		}
	}
}
