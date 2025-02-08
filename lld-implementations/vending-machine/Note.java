package com.practice.vending_machine_system;

public enum Note {
	ONE(1), FIVE(5), TEN(10), TWENTY(20), HUNDRED(100);

	private final int value;

	private Note(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
