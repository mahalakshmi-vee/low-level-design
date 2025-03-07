package com.practice.hotel_management_system;

public class CashPayment implements Payment {

	@Override
	public boolean processPayment(double amount) {
		// Process Cash Payment
		return true;
	}

}
