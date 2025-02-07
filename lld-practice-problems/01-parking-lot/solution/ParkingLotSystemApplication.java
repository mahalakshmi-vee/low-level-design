package com.practice.parking_lot_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotSystemApplication {
	public static void main(String[] args) {
		// Initialize the Spring Boot application
		SpringApplication.run(ParkingLotSystemApplication.class, args);

		try {
			ParkingLot parkingLot = ParkingLot.getInstance();
			parkingLot.displayParkingLotInfo();

			ParkingResult parkingResult = parkingLot.parkVehicle("v1", ParkingSpotType.COMPACT);
			parkingLot.displayParkingLotInfo();
			parkingLot.unParkVehicle(parkingResult.getTicketId());
			parkingLot.displayParkingLotInfo();

			parkingResult = parkingLot.parkVehicle("v2", ParkingSpotType.MOTORBIKE);
			parkingLot.displayParkingLotInfo();
			parkingLot.unParkVehicle(parkingResult.getTicketId());
			parkingLot.displayParkingLotInfo();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
