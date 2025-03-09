package com.practice.car_rental_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystem {
	private static CarRentalSystem instance;
	private Map<String, Car> cars;
	private Map<String, Reservation> reservations;

	private CarRentalSystem() {
		cars = new ConcurrentHashMap<>();
		reservations = new ConcurrentHashMap<>();
	}

	public static synchronized CarRentalSystem getInstance() {
		if (instance != null)
			return instance;

		instance = new CarRentalSystem();
		return instance;
	}

	public void addCar(Car car) {
		cars.put(car.getLicensePlateNumber(), car);
	}

	public void removeCar(String licensePlateNumber) {
		cars.remove(licensePlateNumber);
	}

	public List<Car> searchCar(String make, String model, LocalDate startDate, LocalDate endDate) {
		List<Car> availableCars = new ArrayList<>();
		for (Car car : cars.values()) {
			if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
				if (isCarAvailable(car, startDate, endDate)) {
					availableCars.add(car);
				}
			}
		}
		return availableCars;
	}

	public Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate,
			PaymentProcessor paymentProcessor) throws Exception {
		Reservation reservation = new Reservation(car, customer, startDate, endDate);
		if (!isCarAvailable(car, startDate, endDate)) {
			throw new Exception("Seleted car is not available.");
		}
		if (paymentProcessor.processPayment(reservation.getTotalPrice())) {
			reservation.reserve();
			reservations.put(reservation.getReservationNumber(), reservation);
			System.out
					.println("Reservation confirmed and the reservation number: " + reservation.getReservationNumber());
		} else
			throw new Exception("Pyment is unsuccessfull");
		return null;
	}

	public void cancelReservation(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			reservations.remove(reservationId);
		}
	}

	private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
		for (Reservation reservation : reservations.values()) {
			if (reservation.getCar().equals(car)) {
				if (!(endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate())))
					return false;
			}
		}
		return true;
	}
}
