package com.practice.vending_machine_system;

public class ReturnChangeState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public ReturnChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Please collect the change first.");

	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Please collect the change first.");
	}

	@Override
	public void insertNote(Note note) {
		System.out.println("Please collect the change first.");
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Product already dispensed. Please collect the change first.");
	}

	@Override
	public void returnChange() {
		double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProdut().getPrice();
		if (change > 0) {
			System.out.println("Change returned: " + change);
			vendingMachine.resetPayment();
		} else {
			System.out.println("No change to return.");
		}
		vendingMachine.resetSelectedProduct();
		vendingMachine.setVendingMachineState(vendingMachine.getIdleState());
	}

}
