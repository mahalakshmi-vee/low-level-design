package com.practice.vending_machine_system;

public interface VendingMachineState {
	void selectProduct(Product product);

	void insertCoin(Coin coin);

	void insertNote(Note note);

	void dispenseProduct();

	void returnChange();
}
