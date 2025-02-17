package com.practice.traffic_signal_control_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrafficSignalControlSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficSignalControlSystemApplication.class, args);

		TrafficLight mugalivakkamTrafficLight = new TrafficLight(2 * 1000, 3 * 1000, 4 * 1000);
		Road mugalivakkamRoad = new Road("1", "Mugalivakkam", mugalivakkamTrafficLight);

		TrafficController trafficController = TrafficController.getInstance();
		trafficController.addRoad(mugalivakkamRoad);

		trafficController.startTrafficLightControl();
	}

}
