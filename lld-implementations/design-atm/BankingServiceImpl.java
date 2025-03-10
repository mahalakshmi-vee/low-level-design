package com.practice.atm_system;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BankingServiceImpl implements BankingService {
	private static BankingService instance;
	private Map<String, BankAccount> bankAccounts;

	private BankingServiceImpl() {
		bankAccounts = new ConcurrentHashMap<>();
	}

	public static synchronized BankingService getInstance() {
		if (instance != null)
			return instance;
		instance = new BankingServiceImpl();
		return instance;
	}

	@Override
	public BankAccount createBankAccount(String name, String phoneNumber) {
		String accountNumber = "ACC" + UUID.randomUUID().toString().substring(0, 8);
		ATMCard atmCard = new ATMCard(UUID.randomUUID().toString().substring(0, 5), accountNumber);
		BankAccount bankAccount = new BankAccount(accountNumber, 1000, atmCard, name, phoneNumber);
		bankAccounts.put(accountNumber, bankAccount);
		return bankAccount;
	}

	@Override
	public double getBalance(String bankAccountNumber) {
		BankAccount bankAccount = bankAccounts.get(bankAccountNumber);
		if (bankAccount != null) {
			return bankAccount.getBalance();
		} else
			throw new IllegalArgumentException("Invalid account number");
	}

	@Override
	public BankAccount verifyATMCard(String atmCardNumber) {
		for (BankAccount bankAccount : bankAccounts.values()) {
			if (bankAccount.getAtmCard().getCardNumber().equalsIgnoreCase(atmCardNumber)) {
				return bankAccount;
			}
		}
		return null;
	}

	@Override
	public void withdraw(BankAccount bankAccount, double amount) {
		bankAccount.debit(amount);
	}

	@Override
	public void deposit(BankAccount bankAccount, double amount) {
		bankAccount.credit(amount);
	}

}
