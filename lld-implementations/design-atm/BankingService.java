package com.practice.atm_system;

public interface BankingService {
	BankAccount createBankAccount(String name, String phoneNumber);
	
	double getBalance(String bankAccountNumber);
	
	BankAccount verifyATMCard(String atmCardNumber);
	
	void withdraw(BankAccount bankAccount, double amount);
	
	void deposit(BankAccount bankAccount, double amount);
}
