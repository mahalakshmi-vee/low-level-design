package com.practice.car_rental_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
	private String name;
	private String email;
	private String phoneNumber;
	private String driverLicenseNumber;
}
