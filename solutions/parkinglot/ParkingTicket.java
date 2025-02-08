package com.practice.parking_lot_system;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ParkingTicket {
	private String ticketId;
	private int floorId;
	private String spotId;
	private double parkingFee;
	private LocalDateTime parkingEntryTime;
	private String vehicleNumber;

	public ParkingTicket(String ticketId, int floorId, String spotId, String vehicleNumber) {
		this.ticketId = ticketId;
		this.floorId = floorId;
		this.spotId = spotId;
		parkingEntryTime = LocalDateTime.now();
		this.vehicleNumber = vehicleNumber;
	}

	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
}
