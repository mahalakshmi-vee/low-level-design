package com.practice.parking_lot_system;

public class ParkingSpotFactory {
	public static ParkingSpot createParkingSpot(String spotId, ParkingSpotType parkingSpotType) {
		switch (parkingSpotType) {
		case COMPACT: {
			return new ParkingSpot(spotId, ParkingSpotType.COMPACT);
		}
		case LARGE: {
			return new ParkingSpot(spotId, ParkingSpotType.LARGE);
		}
		case HANDICAPPED: {
			return new ParkingSpot(spotId, ParkingSpotType.HANDICAPPED);
		}
		case MOTORBIKE: {
			return new ParkingSpot(spotId, ParkingSpotType.MOTORBIKE);
		}
		case ELECTRICCAR: {
			return new ParkingSpot(spotId, ParkingSpotType.ELECTRICCAR);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + parkingSpotType);
		}
	}
}
