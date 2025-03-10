package com.practice.atm_system;

public interface ATMState {
	void insertCard(ATMCard atmCard);

	void withdraw(String pin, double amount);

	void ejectCard();
	
	ATMStateEnum getState();
}
