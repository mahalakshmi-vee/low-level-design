package com.practice.car_rental_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Reservation {
	private String reservationNumber;
	private Car car;
	private Customer customer;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalPrice;

	public Reservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
		this.car = car;
		this.customer = customer;
		this.startDate = startDate;
		this.endDate = endDate;
		calculateTotalPrice();
	}

	private void calculateTotalPrice() {
		long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
		double price = car.getRentalPricePerDay() * totalDays;
		this.totalPrice = price;
	}

	public Reservation reserve() {
		reservationNumber = generateReservationNumber();
		car.reserveCar();
		return this;
	}

	public void cancelReservation() {
		car.unReserveCar();
	}

	private String generateReservationNumber() {

		return "RES" + UUID.randomUUID().toString().substring(0, 8);
	}

}
