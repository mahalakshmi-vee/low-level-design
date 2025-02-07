package com.practice.parking_lot_system;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
	private String spotId;
	private ParkingSpotType parkingSpotType;
	private boolean isOccupied;

	public ParkingSpot(String spotId, ParkingSpotType parkingSpotType) {
		this.spotId = spotId;
		this.parkingSpotType = parkingSpotType;
		this.isOccupied = false;
	}
}
