package com.practice.coffee_vending_machine;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
	public static String formatRupees(double amount) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-IN"));
		return currencyFormat.format(amount);
	}
}
