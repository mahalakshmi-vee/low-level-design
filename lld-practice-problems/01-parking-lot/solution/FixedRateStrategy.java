package com.practice.parking_lot_system;

import java.time.Duration;
import java.time.LocalDateTime;

public class FixedRateStrategy implements ParkingFeeCalculationStrategy {
	private static int PER_HOUR_RATE = 10;

	@Override
	public double calculateFee(ParkingResult parkingResult) {
		LocalDateTime entryTime = parkingResult.getEntryTime();
		LocalDateTime exitTime = LocalDateTime.now();

		long minutesParked = Duration.between(entryTime, exitTime).toMinutes();
		double hoursParked = Math.floor(minutesParked / 60);
		return hoursParked * PER_HOUR_RATE;
	}
}
