package com.practice.traffic_signal_control_system;

import lombok.Getter;

@Getter
public class TrafficLight {
	private final int redDuration;
	private final int greenDuration;
	private final int yellowDuration;

	private Signal currentSignal;

	public TrafficLight(int redDuration, int greenDuration, int yellowDuration) {
		this.redDuration = redDuration;
		this.greenDuration = greenDuration;
		this.yellowDuration = yellowDuration;
		currentSignal = Signal.RED;
	}

	public synchronized void changeSignal(Signal signal) {
		currentSignal = signal;
		notifyObservers();
	}

	public void notifyObservers() {
		System.out.println("Current Signal: " + currentSignal);
	}
}
