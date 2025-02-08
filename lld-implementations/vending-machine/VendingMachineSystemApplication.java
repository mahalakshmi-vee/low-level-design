package com.practice.vending_machine_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendingMachineSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(VendingMachineSystemApplication.class, args);
		VendingMachine vendingMachine = VendingMachine.getInstance();
		Inventory inventory = vendingMachine.getInventory();

		Product pepsi = new Product("Pepsi", 15);
		Product chips = new Product("Chips", 25);
		Product water = new Product("Water", 20);
		Product coke = new Product("Coke", 15);

		inventory.addInventory(pepsi, 15);
		inventory.addInventory(chips, 20);
		inventory.addInventory(water, 30);
		inventory.addInventory(coke, 15);
		inventory.displayInventory();
		
		vendingMachine.getCurrentState().selectProduct(coke);

		vendingMachine.getCurrentState().insertNote(Note.TEN);
		vendingMachine.getCurrentState().insertCoin(Coin.TEN);
		
		vendingMachine.getCurrentState().dispenseProduct();

		vendingMachine.getCurrentState().returnChange();
		inventory.displayInventory();
	}
}
