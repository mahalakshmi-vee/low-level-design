package com.practice.atm_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmSystemApplication.class, args);

		ATMSystem atmSystem = ATMSystem.getInstance();
		atmSystem.deposit(new int[] { 40, 30, 50, 100, 100 });

		BankingService bankingService = BankingServiceImpl.getInstance();
		BankAccount bankAccount1 = bankingService.createBankAccount("John", "1234567890");
		ATMCard bankAtmCard1 = bankAccount1.getAtmCard();
		bankingService.deposit(bankAccount1, 200000);

		atmSystem.getCurrentATMState().insertCard(bankAtmCard1);
		atmSystem.getCurrentATMState().withdraw(bankAtmCard1.getPin(), 25000);

		System.out.println("Current ATM State: " + atmSystem.getCurrentATMState().getState());
	
		atmSystem.getCurrentATMState().insertCard(bankAtmCard1);
		atmSystem.getCurrentATMState().ejectCard();
		
		System.out.println("Current ATM State: " + atmSystem.getCurrentATMState().getState());
	}

}
