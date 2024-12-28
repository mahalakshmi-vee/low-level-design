package withFactoryPattern;

import java.util.Scanner;

public class AppMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String vehicleType = scanner.next();
		Vehicle vehicle = VehicleFactory.createVehicle(vehicleType);
		vehicle.createVehicle();
		scanner.close();
	}
}
