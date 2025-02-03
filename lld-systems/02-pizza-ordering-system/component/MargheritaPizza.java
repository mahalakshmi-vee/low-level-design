package component;

public class MargheritaPizza implements Pizza {

	@Override
	public double getCost() {

		return 100;
	}

	@Override
	public String getDescription() {

		return "MargheritaPizza";
	}
}
