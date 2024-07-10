package com.example.CarDealershipSpring;

import com.example.CarDealershipSpring.models.Vehicle;
import com.example.CarDealershipSpring.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarDealershipSpringApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();

//		vehicleList.forEach(System.out::println);

//		System.out.println("Search by price range");
//		System.out.println("min: ");
//		int min = scanner.nextInt();
//		System.out.println("max: ");
//		int max = scanner.nextInt();
//		scanner.nextLine();
//
//		List<Vehicle> vehiclePriceList = vehicleRepository.getVehiclesByPrice(min, max);
//		vehiclePriceList.forEach(System.out::println);

		System.out.println("Search by make model");
		System.out.println("make: ");
		String make = scanner.nextLine();
		System.out.println("model: ");
		String model = scanner.nextLine();

		List<Vehicle> makeModelList = vehicleRepository.getVehiclesByMakeModel(make, model);
		makeModelList.forEach(System.out::println);

	}
}
