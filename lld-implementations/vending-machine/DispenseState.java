package com.practice.vending_machine_system;

public class DispenseState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public DispenseState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Product already selected. Please collect the dispensed product.");

	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Payment already made. Please collect the dispensed product.");
	}

	@Override
	public void insertNote(Note note) {
		System.out.println("Payment already made. Please collect the dispensed product.");
	}

	@Override
	public void dispenseProduct() {
		vendingMachine.setVendingMachineState(vendingMachine.getReadyState());

		Product selectedProduct = vendingMachine.getSelectedProdut();
		Inventory inventory = vendingMachine.getInventory();

		inventory.updateQuantity(selectedProduct, inventory.getQuantity(selectedProduct) - 1);
		System.out.println("Product dispensed " + selectedProduct.getName());
		vendingMachine.setVendingMachineState(vendingMachine.getReturnChangeState());
	}

	@Override
	public void returnChange() {
		System.out.println("Please collect the dispensed product first.");
	}

}
