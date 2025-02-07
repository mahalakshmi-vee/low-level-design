package com.practice.parking_lot_system;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private Map<Integer, ParkingFloor> parkingFloorMap;
	private ParkingSpotStrategy parkingSpotStrategy;
	private ParkingFeeCalculationStrategy parkingFeeCalculationStrategy;
	private Map<String, ParkingResult> activeParkings;

	public Map<Integer, ParkingFloor> getParkingFloorMap() {
		return parkingFloorMap;
	}

	public ParkingLot(int numFloors, Map<ParkingSpotType, Integer> spotCounts, ParkingSpotStrategy parkingSpotStrategy,
			ParkingFeeCalculationStrategy parkingFeeCalculationStrategy) {
		parkingFloorMap = new HashMap<>();
		for (int i = 0; i < numFloors; i++) {
			parkingFloorMap.put(i, new ParkingFloor(i, spotCounts));
		}
		this.parkingSpotStrategy = parkingSpotStrategy;
		activeParkings = new HashMap<>();
		this.parkingFeeCalculationStrategy = parkingFeeCalculationStrategy;
	}

	public void displayParkingLotInfo() {
		for (Map.Entry<Integer, ParkingFloor> entry : parkingFloorMap.entrySet()) {
			ParkingFloor floor = entry.getValue();
			System.out.println(
					"Floor " + floor.getFloorId() + " has " + floor.getAvailableSpots().size() + " available spots.");
		}
	}

	public synchronized ParkingResult parkVehicle(String vehicleNumber, ParkingSpotType parkingSpotType)
			throws Exception {
		ParkingSpot parkingSpot = parkingSpotStrategy.findParkingSpot(this, parkingSpotType);
		if (parkingSpot == null)
			throw new Exception("No available spot.");
		String ticketId = vehicleNumber + "-" + parkingSpot.getSpotId();

		parkingSpot.setOccupied(true);
		ParkingResult parkingResult = new ParkingResult(ticketId, parkingSpot.getSpotId(), vehicleNumber);
		activeParkings.put(ticketId, parkingResult);
		System.out.println("Vehicle parked successfully");
		return parkingResult;
	}

	public void unParkVehicle(String ticketId) {
		ParkingResult parkingResult = activeParkings.get(ticketId);
		for (Map.Entry<Integer, ParkingFloor> entry : parkingFloorMap.entrySet()) {
			ParkingFloor parkingFloor = entry.getValue();
			if (parkingFloor.unParkVehicle(parkingResult.getSpotId())) {
				double parkingFee = parkingFeeCalculationStrategy.calculateFee(parkingResult);
				parkingResult.setParkingFee(parkingFee);
				activeParkings.remove(ticketId);
				System.out.println("Vehicle unparked successfully. Please pay the parking fee in the ticket.");
				return;
			}
		}
	}
}
