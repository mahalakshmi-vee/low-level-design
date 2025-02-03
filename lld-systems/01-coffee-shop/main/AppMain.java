package main;

import component.Coffee;
import component.SimpleCoffee;
import decorator.MilkDecorator;
import decorator.SugarDecorator;

public class AppMain {
	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.getCost());
		System.out.println(coffee.getDescription());

		coffee = new MilkDecorator(coffee);
		System.out.println(coffee.getCost());
		System.out.println(coffee.getDescription());

		coffee = new SugarDecorator(coffee);
		System.out.println(coffee.getCost());
		System.out.println(coffee.getDescription());
	}
}
