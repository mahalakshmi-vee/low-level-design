package com.practice.car_rental_system;

public class CreditCardPaymentProcesor implements PaymentProcessor {
	@Override
	public boolean processPayment(double amount) {
		// Process credit card payment
		return true;
	}
}
