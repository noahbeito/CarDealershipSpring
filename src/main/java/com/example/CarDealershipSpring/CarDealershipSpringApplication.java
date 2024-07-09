package com.example.CarDealershipSpring;

import com.example.CarDealershipSpring.models.Vehicle;
import com.example.CarDealershipSpring.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarDealershipSpringApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();

		vehicleList.forEach(System.out::println);
	}
}
