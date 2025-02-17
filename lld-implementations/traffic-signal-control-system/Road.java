package com.practice.traffic_signal_control_system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Road {
	private String id;
	private String name;
	private TrafficLight trafficLight;
}
