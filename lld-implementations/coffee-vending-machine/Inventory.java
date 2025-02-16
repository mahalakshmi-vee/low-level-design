package com.practice.coffee_vending_machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;

@Getter
public class Inventory {
	private Map<Ingredient, Integer> ingredients;

	public Inventory() {
		ingredients = new ConcurrentHashMap<>();
	}

	// Admin will add ingredients to the inventory and this function is for them.
	public synchronized void addInventory(Ingredient ingredient, int quantity) {
		if (ingredients.containsKey(ingredient)) {
			System.out.println("Ingredient already exists in inventory.");
			return;
		}
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity should be positive.");
		}
		ingredients.put(ingredient, quantity);
	}

	// Admin will update the inventory and this function is for them.
	public synchronized void updateInventory(Ingredient ingredient, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity cannot be negative.");
		}
		ingredients.put(ingredient, quantity);
	}

	// Check if inventory has enough ingredients to make a particular coffee.
	public synchronized boolean checkInventory(Coffee coffee) {
		Map<Ingredient, Integer> ingredients = coffee.getIngredients();
		for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
			Ingredient neededIngredient = entry.getKey();
			int neededQuantity = entry.getValue();
			if (ingredients.get(neededIngredient) < neededQuantity) {
				System.out.println("Not enough " + neededIngredient.getIngredientName());
				return false;
			}
		}
		return true;
	}

	// Update inventory after a coffee is made.
	public synchronized boolean updateInventory(Coffee coffee) {
		Map<Ingredient, Integer> ingredients = coffee.getIngredients();
		for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
			Ingredient neededIngredient = entry.getKey();
			int neededQuantity = entry.getValue();
			int currentQuantity = ingredients.get(neededIngredient);
			if (currentQuantity < neededQuantity) {
				System.out.println("Error: Not enough :" + neededIngredient.getIngredientName());
				return false;
			}
			ingredients.put(neededIngredient, ingredients.get(neededIngredient) - neededQuantity);
		}
		return true;
	}
}
