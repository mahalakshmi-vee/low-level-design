package decorator;

import component.Coffee;

public class MilkDecorator extends CoffeeDecorator {

	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double getCost() {

		return super.getCost() + 15;
	}

	@Override
	public String getDescription() {

		return super.getDescription() + "\nAdded Milk.";
	}
}
