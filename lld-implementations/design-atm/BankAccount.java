package com.practice.atm_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BankAccount {
	private final String accountNumber;
	private double balance;
	private ATMCard atmCard;
	private String name;
	private String phoneNumber;

	public synchronized void debit(double amount) {
		balance -= amount;
	}

	public synchronized void credit(double amount) {
		balance += amount;
	}
}
