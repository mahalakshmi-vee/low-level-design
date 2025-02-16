package com.practice.coffee_vending_machine;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class CoffeeVendingMachine {
	private static CoffeeVendingMachine instance;
	private Inventory inventory;
	private List<Coffee> coffeeMenu;

	private double totalPayment;
	private Coffee selectedCoffee;

	private CoffeeVendingMachine() {
		inventory = new Inventory();
		coffeeMenu = new ArrayList<Coffee>();
	}

	public static synchronized CoffeeVendingMachine getInstance() {
		if (instance != null)
			return instance;
		instance = new CoffeeVendingMachine();
		return instance;
	}

	public void showCoffeeOptions() {
		System.out.println("Available Coffee Varities:");
		for (Coffee coffee : coffeeMenu) {
			System.out.println(
					coffee.getCoffeeName() + " - " + CurrencyFormatter.formatRupees(coffee.getPrice()) + " rupees");
		}
	}

	public void addCoffee(Coffee coffee) {
		coffeeMenu.add(coffee);
	}

	public void updateCoffee(Coffee updatedCoffee) {
		if (!coffeeMenu.contains(updatedCoffee)) {
			System.out.println("Please add the coffee before updating teh details!");
			return;
		}
		int index = coffeeMenu.indexOf(updatedCoffee);
		coffeeMenu.set(index, updatedCoffee);
	}

	public void chooseCoffee(Coffee coffee) {
		if (coffee == null) {
			System.out.println("Please choose a valid coffee");
			return;
		}
		if (inventory.checkInventory(coffee)) {
			selectedCoffee = coffee;
			System.out.println("You have selected " + selectedCoffee.getCoffeeName() + ". Please pay "
					+ CurrencyFormatter.formatRupees(selectedCoffee.getPrice()) + " rupees.");
		} else {
			System.out.println("Not enough ingredients to prepare " + selectedCoffee.getCoffeeName());
		}
	}

	public void buyCoffee(double payment) {
		if (selectedCoffee == null) {
			System.out.println("Please select a coffee first.");
			return;
		}
		if (payment < selectedCoffee.getPrice()) {
			System.out.println("Insufficient payment! Please provide the correct amount.");
			return;
		}
		totalPayment += payment;
		inventory.updateInventory(selectedCoffee);
		double balance = totalPayment - selectedCoffee.getPrice();
		if (balance > 0) {
			System.out.println("Please collect your change: " + CurrencyFormatter.formatRupees(balance) + " rupees.");
		}
		System.out.println("Your coffee " + selectedCoffee.getCoffeeName() + " is ready. Thank you for your purchase!");

		// Reset transaction and payment after transaction.
		selectedCoffee = null;
		totalPayment = 0;
	}

}
