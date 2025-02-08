package com.practice.parking_lot_system;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private static ParkingLot parkingLot;
	private Map<Integer, ParkingFloor> parkingFloors;
	private Map<String, ParkingTicket> activeParkings;
	private ParkingFeeCalculationStrategy parkingFeeCalculationStrategy;

	private ParkingLot() {
		int floorCount = 2;
		Map<ParkingSpotType, Integer> spotsCount = new HashMap<>();
		spotsCount.put(ParkingSpotType.COMPACT, 2);
		spotsCount.put(ParkingSpotType.MOTORCYCLE, 3);

		parkingFloors = new HashMap<>();
		for (int i = 1; i <= floorCount; i++) {
			parkingFloors.put(i, new ParkingFloor(i, spotsCount));
		}

		activeParkings = new HashMap<>();
		parkingFeeCalculationStrategy = new FixedRateStrategy();
	}

	public static ParkingLot getInstance() {
		if (parkingLot != null)
			return parkingLot;
		parkingLot = new ParkingLot();
		return parkingLot;
	}

	public synchronized ParkingTicket parkVehicle(String vehicleNumber, ParkingSpotType parkingSpotType) {
		for (ParkingFloor parkingFloor : parkingFloors.values()) {
			ParkingSpot parkingSpot = parkingFloor.findFirstAvailableSpot(parkingSpotType);
			if (parkingSpot == null)
				continue;

			int floorId = parkingFloor.getId();
			String spotId = parkingSpot.getId();
			String ticketId = vehicleNumber + spotId;

			parkingSpot.parkVehicle();
			ParkingTicket ticket = new ParkingTicket(ticketId, floorId, spotId, vehicleNumber);
			activeParkings.put(ticket.getTicketId(), ticket);
			System.out.println("Vehicle " + vehicleNumber + " parked successfully!");
			System.out.println("Parked spot Id: " + ticket.getSpotId());
			return ticket;
		}
		System.out.println("No available spots found. Please wait for some time.");
		return null;
	}

	public synchronized void unParkVehicle(String ticketId) {
		if (!activeParkings.containsKey(ticketId)) {
			System.out.println("Please check the ticketId entered...");
			return;
		}
		ParkingTicket ticket = activeParkings.get(ticketId);
		ParkingFloor parkingFloor = parkingFloors.get(ticket.getFloorId());
		ParkingSpot parkingSpot = parkingFloor.getParkingSpots().get(ticket.getSpotId());

		parkingSpot.unParkVehicle();
		ticket.setParkingFee(parkingFeeCalculationStrategy.calculateFee(ticket));
		activeParkings.remove(ticketId);
		System.out.println("Vechile " + ticket.getVehicleNumber() + " unparked successfully!");
		System.out.println("Unparked spot Id: " + ticket.getSpotId());
		System.out.println("Please pay the amount specified in the ticket.");
	}

	public void trackAvailableParkingSpots() {
		System.out.println("Tracking the available parking spot");
		for (ParkingFloor parkingFloor : parkingFloors.values()) {
			parkingFloor.trackAvailableParkingSpots();
		}
	}
}
