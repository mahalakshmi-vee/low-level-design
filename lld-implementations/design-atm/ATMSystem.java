package com.practice.atm_system;

public class ATMSystem {
	private static ATMSystem instance;
	private final int[] denominations = { 500, 200, 100, 50, 20 };
	private final int supportedDenominationsCount;
	private int[] notesCount;

	private ATMState currentATMState;
	private ATMState readyATMState;
	private ATMState ejectATMState;
	private ATMState withdrawATMState;

	private ATMCard atmCard;
	private BankAccount bankAccount;

	private ATMSystem() {
		supportedDenominationsCount = 5;
		notesCount = new int[supportedDenominationsCount];

		readyATMState = new ReadyATMState(this);
		currentATMState = readyATMState;
		ejectATMState = new EjectCardATMState(this);
		withdrawATMState = new WithdrawATMState(this);

		atmCard = null;
		bankAccount = null;
	}

	public static synchronized ATMSystem getInstance() {
		if (instance != null)
			return instance;
		instance = new ATMSystem();
		return instance;
	}

	public ATMState getReadyATMState() {
		return readyATMState;
	}

	public ATMState getEjectATMState() {
		return ejectATMState;
	}

	public ATMState getWithdrawATMState() {
		return withdrawATMState;
	}

	public ATMState getCurrentATMState() {
		return currentATMState;
	}

	public void setCurrentATMState(ATMState atmState) {
		this.currentATMState = atmState;
	}

	public void setATMCard(ATMCard atmCard) {
		this.atmCard = atmCard;
	}

	public ATMCard getATMCard() {
		return atmCard;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void deposit(int[] notesCount) {
		for (int i = 0; i < supportedDenominationsCount; i++) {
			this.notesCount[i] += notesCount[i];
		}
	}

	public boolean calculateDenominations(double amount) {
		int[] answerArray = new int[supportedDenominationsCount];
		int[] tempNotesCount = new int[supportedDenominationsCount];
		tempNotesCount = notesCount.clone();
		for (int i = 0; i < supportedDenominationsCount; i++) {
			int notesRequire = (int) amount / denominations[i];
			if (notesRequire > 0 && tempNotesCount[i] != 0) {
				notesRequire = Math.min(notesRequire, tempNotesCount[i]);
				amount -= (notesRequire * denominations[i]);
				tempNotesCount[i] -= notesRequire;
				answerArray[i] = notesRequire;
			}
		}
		if (amount != 0) {
			System.out.println("Requested amount cannot be dispensed due to unavailable denominations.");
			return false;
		}

		// Update the ATM notes count.
		notesCount = tempNotesCount;

		// Print the dispensed denominations
		printDenominationDetails(answerArray);
		return true;
	}

	private void printDenominationDetails(int[] answerArray) {
		System.out.println("Dispensed Cash:");
		for (int i = 0; i < answerArray.length; i++) {
			if (answerArray[i] == 0)
				continue;
			System.out.println(denominations[i] + " notes count: " + answerArray[i]);
		}
	}
}
