package com.practice.car_rental_system;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarRentalSystemApplication.class, args);

		CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

		carRentalSystem.addCar(new Car("Toyota", "Camry", 2022, "ABC123", 50.00));
		carRentalSystem.addCar(new Car("Honda", "Civic", 2021, "XYZ789", 45.00));
		carRentalSystem.addCar(new Car("Ford", "Mustang", 2023, "DEF456", 80.00));

		Customer customer1 = new Customer("John", "john@gmail.com", "1234567890", "DL1234");
		Customer customer2 = new Customer("Marry", "marry@gmail.com", "12345678890", "ABC34");

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusDays(3);

		List<Car> availableCars = carRentalSystem.searchCar("Toyota", "Camry", startDate, endDate);
		PaymentProcessor cashPaymentProcessor = new CashPaymentProcessor();
		if (!availableCars.isEmpty()) {
			Car selectedCar = availableCars.get(0);
			try {
				// Customer1 => 09-03-2025 to 11-03-2025
				// Customer2 => 07-03-2025 to 09-03-2025
				carRentalSystem.makeReservation(customer1, selectedCar, startDate, endDate, cashPaymentProcessor);
				carRentalSystem.makeReservation(customer2, selectedCar, startDate.minusDays(2), endDate.minusDays(2),
						cashPaymentProcessor);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
