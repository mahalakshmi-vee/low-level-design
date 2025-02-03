package component;

public class FarmHousePizza implements Pizza{

	@Override
	public double getCost() {
		
		return 120;
	}

	@Override
	public String getDescription() {
		
		return "FarmHousePizza";
	}
}
