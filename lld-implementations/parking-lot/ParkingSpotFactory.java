package com.practice.parking_lot_system;

public class ParkingSpotFactory {
	public static ParkingSpot createParkingSpot(int floorId, String spotId, ParkingSpotType parkingSpotType) {
		switch (parkingSpotType) {
		case COMPACT: {
			return new ParkingSpot(spotId, parkingSpotType, false, floorId);
		}
		case LARGE: {
			return new ParkingSpot(spotId, parkingSpotType, false, floorId);
		}
		case HANDICAPPED: {
			return new ParkingSpot(spotId, parkingSpotType, false, floorId);
		}
		case MOTORCYCLE: {
			return new ParkingSpot(spotId, parkingSpotType, false, floorId);
		}
		case ELECTRIC: {
			return new ParkingSpot(spotId, parkingSpotType, false, floorId);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + parkingSpotType);
		}
	}
}
