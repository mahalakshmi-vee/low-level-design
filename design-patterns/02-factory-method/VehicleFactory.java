package withFactoryPattern;

public class VehicleFactory {
	public static Vehicle createVehicle(String vehicleType) {
		Vehicle vehicle = null;
		if (vehicleType.equalsIgnoreCase("car")) {
			vehicle = new Car();
		} else if (vehicleType.equalsIgnoreCase("bike")) {
			vehicle = new Bike();
		}
//		In the future, if any new vehicle type comes up, we need to add another if
//		condition to support that type, and this is violating the open/closed
//		principle since we are modifying the existing code.
		return vehicle;
	}
}
