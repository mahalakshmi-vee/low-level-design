package com.practice.coffee_vending_machine;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coffee {
	private int coffeeId;
	private String coffeeName;
	private Map<Ingredient, Integer> ingredients;
	private double price;
}
