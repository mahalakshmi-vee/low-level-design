package decorator;

import component.Pizza;

public class OlivesPizzaDecorator extends PizzaDecorator {
	private static final double OLIVES_COST = 15;

	public OlivesPizzaDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public double getCost() {

		return super.getCost() + OLIVES_COST;
	}

	@Override
	public String getDescription() {

		return super.getDescription() + " , Added olives (₹" + OLIVES_COST + ")";
	}
}
