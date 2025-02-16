package com.practice.coffee_vending_machine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ingredient {
	private int ingredientId;
	private String ingredientName;
	private String unit;
}
