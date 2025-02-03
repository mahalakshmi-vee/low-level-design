package main;

import component.FarmHousePizza;
import component.Pizza;
import decorator.MushroomPizzaDecorator;
import decorator.OlivesPizzaDecorator;

public class AppMain {
	public static void main(String[] args) {
		Pizza pizza = new FarmHousePizza();
		System.out.println("Base Pizza: " + pizza.getDescription());
		System.out.println("Cost: ₹" + pizza.getCost());

		pizza = new MushroomPizzaDecorator(pizza);
		System.out.println("After Adding Mushrooms: " + pizza.getDescription());
		System.out.println("Cost: ₹" + pizza.getCost());

		pizza = new OlivesPizzaDecorator(pizza);
		System.out.println("After Adding Olives: " + pizza.getDescription());
		System.out.println("Cost: ₹" + pizza.getCost());

		System.out.println("Final Pizza: " + pizza.getDescription());
		System.out.println("Final Cost: ₹" + pizza.getCost());
	}
}
