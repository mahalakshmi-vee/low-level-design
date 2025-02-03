package decorator;

import component.Pizza;

public class MushroomPizzaDecorator extends PizzaDecorator {
	private static final double MUSHROOM_COST = 40.0;

	public MushroomPizzaDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public double getCost() {

		return super.getCost() + MUSHROOM_COST;
	}

	@Override
	public String getDescription() {

		return super.getDescription() + " , Added mushrooms (₹" + MUSHROOM_COST + ")";
	}
}
