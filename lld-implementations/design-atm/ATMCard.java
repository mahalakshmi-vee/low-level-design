package com.practice.atm_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ATMCard {
	private final String cardNumber;
	private final String pin;

	public boolean validatePIN(String pinToCheck) {

		return pinToCheck.equals(pin);
	}
}
