package com.practice.atm_system;

public class ReadyATMState implements ATMState {
	private ATMSystem atmSystem;
	private final BankingService bankingService;

	public ReadyATMState(ATMSystem atmSystem) {
		this.atmSystem = atmSystem;
		bankingService = BankingServiceImpl.getInstance();
	}

	@Override
	public void insertCard(ATMCard atmCard) {
		// If card is valid
		BankAccount bankAccount =  bankingService.verifyATMCard(atmCard.getCardNumber());
		if (bankAccount != null) {
			atmSystem.setBankAccount(bankAccount);
			atmSystem.setATMCard(atmCard);
			atmSystem.setCurrentATMState(atmSystem.getWithdrawATMState());
		}
		// Else if card is invalid
		else {
			atmSystem.setCurrentATMState(atmSystem.getEjectATMState());
			atmSystem.getCurrentATMState().ejectCard();
		}
	}

	@Override
	public void withdraw(String pin, double amount) {
		System.out.println("ATM is in ready state. Withdraw operations cannot be performed.");
	}

	@Override
	public void ejectCard() {
		System.out.println("ATM is is in ready state. Continue using.");
	}

	@Override
	public ATMStateEnum getState() {
		return ATMStateEnum.READY;
	}
}
