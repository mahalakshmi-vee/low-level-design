package com.practice.atm_system;

public class WithdrawATMState implements ATMState {
	private final ATMSystem atmSystem;
	private BankingService bankingService;

	public WithdrawATMState(ATMSystem atmSystem) {
		this.atmSystem = atmSystem;
		bankingService = BankingServiceImpl.getInstance();
	}

	@Override
	public void insertCard(ATMCard atmCard) {
		System.out.println("Card is already inserted. Process the withdraw/cancel transaction.");
	}

	@Override
	public void withdraw(String pin, double amount) {
		// If pin is valid
		ATMCard atmCard = atmSystem.getATMCard();
		if (!atmCard.validatePIN(pin)) {
			System.out.println("Please check the pin entered");
			return;
		}
		BankAccount bankAccount = atmSystem.getBankAccount();
		if (bankAccount.getBalance() <= amount) {
			System.out.println("Insufficient balance.");
			return;
		}
		if (atmSystem.calculateDenominations(amount)) {
			bankingService.withdraw(bankAccount, amount);
			atmSystem.setCurrentATMState(atmSystem.getEjectATMState());
			atmSystem.getCurrentATMState().ejectCard();
		}
	}

	@Override
	public void ejectCard() {
		atmSystem.setCurrentATMState(atmSystem.getEjectATMState());
		atmSystem.getCurrentATMState().ejectCard();
	}

	@Override
	public ATMStateEnum getState() {
		return ATMStateEnum.WITHDRAW;
	}
}
