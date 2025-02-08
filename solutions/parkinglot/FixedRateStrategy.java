package com.practice.parking_lot_system;

import java.time.Duration;
import java.time.LocalDateTime;

public class FixedRateStrategy implements ParkingFeeCalculationStrategy {
	private static final double PER_HOUR_PARKING_RATE = 10.00;

	@Override
	public double calculateFee(ParkingTicket ticket) {
		LocalDateTime exitTime = LocalDateTime.now();
		long minutes = Duration.between(ticket.getParkingEntryTime(), exitTime).toMinutes();
		long hours = minutes / 60;
		return hours * PER_HOUR_PARKING_RATE;
	}

}
