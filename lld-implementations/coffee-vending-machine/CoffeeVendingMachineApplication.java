package com.practice.coffee_vending_machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeVendingMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeVendingMachineApplication.class, args);

		CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getInstance();
		Inventory inventory = coffeeVendingMachine.getInventory();

		Ingredient milk = new Ingredient(1, "Milk", "millilitre");
		Ingredient sugar = new Ingredient(2, "Sugar", "gram");
		Ingredient water = new Ingredient(3, "Water", "millilitre");
		Ingredient coffeePowder = new Ingredient(4, "Coffee Powder", "gram");
		Ingredient teaPowder = new Ingredient(5, "Tea Powder", "gram");
		Ingredient greeTeaPowder = new Ingredient(6, "Gree Tea Powder", "gram");

		inventory = new Inventory();
		inventory.addInventory(milk, 10000);
		inventory.addInventory(sugar, 10000);
		inventory.addInventory(water, 15000);
		inventory.addInventory(coffeePowder, 2000);
		inventory.addInventory(teaPowder, 2000);
		inventory.addInventory(greeTeaPowder, 2000);

		Map<Ingredient, Integer> bruCoffeeIngredients = new ConcurrentHashMap<>();
		bruCoffeeIngredients.put(milk, 50);
		bruCoffeeIngredients.put(sugar, 10);
		bruCoffeeIngredients.put(coffeePowder, 5);

		Coffee bruCoffee = new Coffee(1, "Bru Coffee", bruCoffeeIngredients, 30);
		coffeeVendingMachine.addCoffee(bruCoffee);

		Map<Ingredient, Integer> greenTeaCoffeeIngredients = new ConcurrentHashMap<>();
		greenTeaCoffeeIngredients.put(water, 50);
		greenTeaCoffeeIngredients.put(greeTeaPowder, 5);

		Coffee greeTeaCoffee = new Coffee(2, "Green Tea", greenTeaCoffeeIngredients, 25);
		coffeeVendingMachine.addCoffee(greeTeaCoffee);

		coffeeVendingMachine.showCoffeeOptions();

		coffeeVendingMachine.chooseCoffee(greeTeaCoffee);

		coffeeVendingMachine.buyCoffee(100);
	}

}
