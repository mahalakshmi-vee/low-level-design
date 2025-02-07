package com.practice.parking_lot_system;

public class FirstAvailableSpotStrategy implements ParkingSpotStrategy {
	@Override
	public synchronized ParkingSpot findParkingSpot(ParkingLot parkingLot, ParkingSpotType parkingSpotType) {
		for (ParkingFloor parkingFloor : parkingLot.getParkingFloorMap().values()) {
			ParkingSpot availableSpot = parkingFloor.findFirstAvailableSpot(parkingSpotType);
			if (availableSpot != null)
				return availableSpot;
		}
		return null; // No available spot.
	}
}
