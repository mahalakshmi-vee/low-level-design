package com.practice.parking_lot_system;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingResult {
	private String ticketId;
	private String spotId;
	private String vehicleNumber;
	private LocalDateTime entryTime;
	private double parkingFee;

	public ParkingResult(String ticketId, String spotId, String vehicleNumber) {
		this.ticketId = ticketId;
		this.spotId = spotId;
		this.vehicleNumber = vehicleNumber;
		entryTime = LocalDateTime.now();
	}
}
