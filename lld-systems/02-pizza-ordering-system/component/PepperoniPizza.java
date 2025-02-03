package component;

public class PepperoniPizza implements Pizza {

	@Override
	public double getCost() {

		return 150;
	}

	@Override
	public String getDescription() {

		return "PepperoniPizza";
	}
}
