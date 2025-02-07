package com.practice.vending_machine_system;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
	private Map<Product, Integer> products;

	public Inventory() {
		products = new ConcurrentHashMap<>();
	}

	public void addInventory(Product product, int quantity) {
		products.put(product, quantity);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public void updateQuantity(Product product, int quantity) {
		products.put(product, quantity);
	}

	public int getQuantity(Product product) {
		return products.getOrDefault(product, 0);
	}

	public boolean isAvailable(Product product) {
		return products.containsKey(product) && products.get(product) > 0;
	}

	public void displayInventory() {
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			System.out.println(entry.getKey().getName() + " - Available Quantity: " + entry.getValue());
		}
	}
}
