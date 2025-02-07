package com.practice.parking_lot_system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotSystemApplication {
	public static void main(String[] args) {
		// Initialize the Spring Boot application
		SpringApplication.run(ParkingLotSystemApplication.class, args);

		try {
			// Initialize the spot counts
			Map<ParkingSpotType, Integer> spotCounts = new HashMap<>();
			spotCounts.put(ParkingSpotType.COMPACT, 3);
			spotCounts.put(ParkingSpotType.LARGE, 2);
			spotCounts.put(ParkingSpotType.HANDICAPPED, 3);
			spotCounts.put(ParkingSpotType.MOTORBIKE, 4);
			spotCounts.put(ParkingSpotType.ELECTRICCAR, 5);

			ParkingSpotStrategy parkingSpotStrategy = new FirstAvailableSpotStrategy();
			ParkingFeeCalculationStrategy parkingFeeCalculationStrategy = new FixedRateStrategy();

			ParkingLot parkingLot = new ParkingLot(3, spotCounts, parkingSpotStrategy, parkingFeeCalculationStrategy);
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
