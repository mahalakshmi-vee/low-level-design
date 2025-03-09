package com.practice.car_rental_system;

import lombok.Getter;

@Getter
public class Car {
	private String make;
	private String model;
	private int year;
	private String licensePlateNumber;
	private double rentalPricePerDay;
	private boolean available;

	public Car(String make, String model, int year, String licensePlateNumber, double rentalPricePerDay) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlateNumber = licensePlateNumber;
		this.rentalPricePerDay = rentalPricePerDay;
		this.available = true;
	}

	public void reserveCar() {
		available = false;
	}

	public void unReserveCar() {
		available = true;
	}
}
