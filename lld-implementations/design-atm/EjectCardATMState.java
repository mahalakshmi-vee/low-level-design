package com.practice.atm_system;

public class EjectCardATMState implements ATMState {
	private final ATMSystem atmSystem;

	public EjectCardATMState(ATMSystem atmSystem) {
		this.atmSystem = atmSystem;
	}

	@Override
	public void insertCard(ATMCard atmCard) {
		System.out.println("ATM is in eject card state. Please cancel the transaction to continue the operations.");
	}

	@Override
	public void withdraw(String pin, double amount) {
		System.out.println("ATM is in eject card state. Please cancel the transaction to continue the operations.");
	}

	@Override
	public void ejectCard() {
		System.out.println("Card is ejected successfully.");
		atmSystem.setATMCard(null);
		atmSystem.setBankAccount(null);
		atmSystem.setCurrentATMState(atmSystem.getReadyATMState());
	}

	@Override
	public ATMStateEnum getState() {
		return ATMStateEnum.EJECT;
	}
}
