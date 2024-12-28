package withFactoryPattern;

public class Bike extends Vehicle {

	@Override
	public void createVehicle() {

		System.out.println("Creating Bike");
	}

}
