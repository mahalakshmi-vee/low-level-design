package com.practice.parking_lot_system;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class ParkingFloor {
	private int id;
	private Map<String, ParkingSpot> parkingSpots;

	public ParkingFloor(int id, Map<ParkingSpotType, Integer> spotsCount) {
		this.id = id;
		int spotIdNumber = 1;

		parkingSpots = new HashMap<>();
		for (Map.Entry<ParkingSpotType, Integer> entry : spotsCount.entrySet()) {
			int spotsCnt = entry.getValue();
			for (int i = 1; i <= spotsCnt; i++) {
				String spotId = "F" + String.valueOf(id) + "S" + String.valueOf(spotIdNumber++);
				parkingSpots.put(spotId, ParkingSpotFactory.createParkingSpot(id, spotId, entry.getKey()));
			}
		}
	}

	public ParkingSpot findFirstAvailableSpot(ParkingSpotType parkingSpotType) {
		for (ParkingSpot parkingSpot : parkingSpots.values()) {
			if (!parkingSpot.isOccupied() && parkingSpot.getParkingSpotType().equals(parkingSpotType)) {
				return parkingSpot;
			}
		}
		return null;
	}

	public void trackAvailableParkingSpots() {
		for (ParkingSpot parkingSpot : parkingSpots.values()) {
			if (parkingSpot.isOccupied())
				continue;
			System.out.println(parkingSpot.getId());
		}
	}
}
