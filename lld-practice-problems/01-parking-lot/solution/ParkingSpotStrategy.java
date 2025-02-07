package com.practice.parking_lot_system;

public interface ParkingSpotStrategy {
	ParkingSpot findParkingSpot(ParkingLot parkingLot, ParkingSpotType parkingSpotType);
}
