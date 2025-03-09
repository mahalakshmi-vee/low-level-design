package com.practice.car_rental_system;

public class CashPaymentProcessor implements PaymentProcessor {
	@Override
	public boolean processPayment(double amount) {
		// Process cash payment
		return true;
	}
}
