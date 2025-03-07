package com.practice.hotel_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
	private static HotelManagementSystem instance;
	private Map<String, Guest> guests;
	private Map<String, Room> rooms;
	private Map<String, Reservation> reservations;

	private HotelManagementSystem() {
		guests = new ConcurrentHashMap<>();
		rooms = new ConcurrentHashMap<>();
		reservations = new ConcurrentHashMap<>();
	}

	public static synchronized HotelManagementSystem getInstance() {
		if (instance != null)
			return instance;
		instance = new HotelManagementSystem();
		return instance;
	}

	public void addGuest(Guest guest) {
		guests.put(guest.getId(), guest);
	}

	public Guest getGuest(String guestId) {
		return guests.get(guestId);
	}

	public void addRoom(Room room) {
		rooms.put(room.getId(), room);
	}

	public Room getRoom(String roomId) {
		return rooms.get(roomId);
	}

	public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
		if (room.getRoomStatus() == RoomStatus.AVAILABLE) {
			room.bookRoom();
			String reservationId = generateReservationId();
			Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate,
					ReservationStatus.CONFIRMED);
			reservations.put(reservationId, reservation);
			return reservation;
		}
		return null;
	}

	public synchronized void cancelReservation(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			reservation.cancelReservation();
			reservations.remove(reservationId);
		}
	}

	public synchronized void checkIn(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			reservation.getRoom().checkIn();
		} else {
			throw new IllegalStateException("Invalid reservation id.");
		}
	}

	public synchronized void checkOut(String reservationId, Payment payment) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			double amount = reservation.getRoom().getPrice()
					* ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
			if (payment.processPayment(amount)) {
				reservation.getRoom().checkOut();
				reservations.remove(reservationId);
			} else {
				throw new IllegalStateException("Payment failed.");
			}
		} else {
			throw new IllegalStateException("Invalid reservation id.");
		}
	}

	public String generateReservationId() {

		return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
}
