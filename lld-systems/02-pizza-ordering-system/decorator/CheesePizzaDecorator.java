package decorator;

import component.Pizza;

public class CheesePizzaDecorator extends PizzaDecorator {
	private static final double CHEESE_COST = 25;

	public CheesePizzaDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public double getCost() {

		return super.getCost() + CHEESE_COST;
	}

	@Override
	public String getDescription() {

		return super.getDescription() + " , Added chesse (₹" + CHEESE_COST + ")";
	}
}
