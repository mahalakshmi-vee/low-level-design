package com.practice.hotel_management_system;

public class CreditCardPayment implements Payment {

	@Override
	public boolean processPayment(double amount) {
		// Process Credit Card Payment
		return true;
	}

}
