package com.practice.vending_machine_system;

public class VendingMachine {
	private static VendingMachine vendingMachine;
	private VendingMachineState idleState;
	private VendingMachineState readyState;
	private VendingMachineState dispenseState;
	private VendingMachineState returnChangeState;
	private VendingMachineState currentState;
	private Inventory inventory;

	private Product selectedProduct;
	private double totalPayment;

	private VendingMachine() {
		inventory = new Inventory();
		idleState = new IdleState(this);
		readyState = new ReadyState(this);
		dispenseState = new DispenseState(this);
		returnChangeState = new ReturnChangeState(this);
		currentState = idleState;
	}

	public static synchronized VendingMachine getInstance() {
		if (vendingMachine != null)
			return vendingMachine;

		vendingMachine = new VendingMachine();
		return vendingMachine;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setSelectedProduct(Product product) {
		selectedProduct = product;
	}

	public Product getSelectedProdut() {
		return selectedProduct;
	}

	public void resetSelectedProduct() {
		selectedProduct = null;
	}

	public void resetPayment() {
		totalPayment = 0;
	}

	public void setVendingMachineState(VendingMachineState vendingMachineState) {
		currentState = vendingMachineState;
	}

	public VendingMachineState getCurrentState() {
		return currentState;
	}

	public VendingMachineState getIdleState() {
		return idleState;
	}

	public VendingMachineState getReadyState() {
		return readyState;
	}

	public VendingMachineState getDispenseState() {
		return dispenseState;
	}

	public VendingMachineState getReturnChangeState() {
		return returnChangeState;
	}

	public void addCoin(Coin coin) {
		totalPayment += coin.getValue();
	}

	public void addNote(Note note) {
		totalPayment += note.getValue();
	}

	public double getTotalPayment() {
		return totalPayment;
	}
}
