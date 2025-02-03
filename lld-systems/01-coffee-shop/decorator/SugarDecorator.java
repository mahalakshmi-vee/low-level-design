package decorator;

import component.Coffee;

public class SugarDecorator extends CoffeeDecorator {
	public SugarDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double getCost() {

		return super.getCost() + 5;
	}

	@Override
	public String getDescription() {

		return super.getDescription() + "\nAdded Sugar.";
	}
}
