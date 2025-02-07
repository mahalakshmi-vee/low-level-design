package com.practice.parking_lot_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
	private int floorId;
	private Map<String, ParkingSpot> parkingSpotMap;

	public int getFloorId() {
		return floorId;
	}

	public ParkingFloor(int floorId, Map<ParkingSpotType, Integer> spotCounts) {
		this.floorId = floorId;
		parkingSpotMap = new HashMap<>();
		initializeSpots(spotCounts);
	}

	private void initializeSpots(Map<ParkingSpotType, Integer> spotCounts) {
		int uniqueValue = 1;
		for (Map.Entry<ParkingSpotType, Integer> entry : spotCounts.entrySet()) {
			ParkingSpotType parkingSpotType = entry.getKey();
			int spotCount = entry.getValue();

			for (int i = 0; i < spotCount; i++) {
				String spotId = String.valueOf(floorId) + " " + String.valueOf(uniqueValue++);

				parkingSpotMap.put(spotId, ParkingSpotFactory.createParkingSpot(spotId, parkingSpotType));
			}
		}
	}

	public boolean unParkVehicle(String spotId) {
		if (!parkingSpotMap.containsKey(spotId))
			return false;
		ParkingSpot parkingSpot = parkingSpotMap.get(spotId);
		parkingSpot.unOccupySpot();
		return true;
	}

	public List<String> getAvailableSpots() {
		List<String> listAvailableSpots = new ArrayList<>();
		for (Map.Entry<String, ParkingSpot> entry : parkingSpotMap.entrySet()) {
			ParkingSpot parkingSpot = entry.getValue();
			if (!parkingSpot.isOccupied()) {
				listAvailableSpots.add(parkingSpot.getSpotId());
			}
		}
		return listAvailableSpots;
	}

	public ParkingSpot findFirstAvailableSpot(ParkingSpotType parkingSpotType) {
		for (Map.Entry<String, ParkingSpot> entry : parkingSpotMap.entrySet()) {
			ParkingSpot parkingSpot = entry.getValue();
			if (!parkingSpot.isOccupied() && parkingSpot.getParkingSpotType().equals(parkingSpotType)) {
				return parkingSpot;
			}
		}
		return null;
	}
}
