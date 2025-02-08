package com.practice.parking_lot_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotSystemApplication.class, args);

		ParkingLot parkingLot = ParkingLot.getInstance();
		parkingLot.trackAvailableParkingSpots();

		ParkingTicket ticket = parkingLot.parkVehicle("v1", ParkingSpotType.COMPACT);
		parkingLot.trackAvailableParkingSpots();

		parkingLot.unParkVehicle(ticket.getTicketId());
		parkingLot.trackAvailableParkingSpots();

		parkingLot.unParkVehicle(ticket.getTicketId()); // System will not recognize this ticket.
	}

}
