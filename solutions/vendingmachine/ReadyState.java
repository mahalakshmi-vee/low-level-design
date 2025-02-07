package com.practice.vending_machine_system;

public class ReadyState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public ReadyState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Product already seleced. Please make payment.");
	}

	@Override
	public void insertCoin(Coin coin) {
		vendingMachine.addCoin(coin);
		checkPaymentStatus();
	}

	@Override
	public void insertNote(Note note) {
		vendingMachine.addNote(note);
		checkPaymentStatus();
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Please make payment first.");
	}

	@Override
	public void returnChange() {
		System.out.println("Please make payment first");
	}

	public void checkPaymentStatus() {
		if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProdut().getPrice()) {
			vendingMachine.setVendingMachineState(vendingMachine.getDispenseState());
		}
	}

}
