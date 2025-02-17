package com.practice.traffic_signal_control_system;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
	private static TrafficController instance;
	private Map<String, Road> roads;

	private TrafficController() {
		roads = new HashMap<>();
	}

	public static synchronized TrafficController getInstance() {
		if (instance != null)
			return instance;

		instance = new TrafficController();
		return instance;
	}

	public void addRoad(Road road) {
		roads.put(road.getId(), road);
	}

	public void removeRoad(String roadId) {
		roads.remove(roadId);
	}

	public void startTrafficLightControl() {
		for (Road road : roads.values()) {
			TrafficLight trafficLight = road.getTrafficLight();
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							Thread.sleep(trafficLight.getRedDuration());
							trafficLight.changeSignal(Signal.GREEN);
							Thread.sleep(trafficLight.getGreenDuration());
							trafficLight.changeSignal(Signal.YELLOW);
							Thread.sleep(trafficLight.getYellowDuration());
							trafficLight.changeSignal(Signal.RED);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		}
	}

	public void handleEmergency(String roadId) {
		Road road = roads.get(roadId);
		if (road != null) {
			TrafficLight trafficLight = road.getTrafficLight();
			trafficLight.changeSignal(Signal.RED);
		}
	}
}
