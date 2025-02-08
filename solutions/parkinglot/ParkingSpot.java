package com.practice.parking_lot_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParkingSpot {
	private String id;
	private ParkingSpotType parkingSpotType;
	private boolean isOccupied;
	private int floorId;

	public void parkVehicle() {
		isOccupied = true;
	}

	public void unParkVehicle() {
		isOccupied = false;
	}
}
