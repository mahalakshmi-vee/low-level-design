package decorator;

import component.Coffee;

public abstract class CoffeeDecorator implements Coffee {
	private Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		decoratedCoffee = coffee;
	}

	@Override
	public double getCost() {

		return decoratedCoffee.getCost();
	}

	@Override
	public String getDescription() {

		return decoratedCoffee.getDescription();
	}
}
