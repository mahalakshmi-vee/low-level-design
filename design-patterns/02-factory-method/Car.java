package withFactoryPattern;

public class Car extends Vehicle {

	@Override
	public void createVehicle() {
		
		System.out.println("Creating Car");
	}

}
