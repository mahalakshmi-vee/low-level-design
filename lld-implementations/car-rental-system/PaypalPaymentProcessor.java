package com.practice.car_rental_system;

public class PaypalPaymentProcessor implements PaymentProcessor {
	@Override
	public boolean processPayment(double amount) {
		// Process Paypal payment.
		return true;
	}
}
