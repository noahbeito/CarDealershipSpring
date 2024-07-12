package com.example.CarDealershipSpring;

import com.example.CarDealershipSpring.models.Dealership;
import com.example.CarDealershipSpring.models.Vehicle;
import com.example.CarDealershipSpring.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserInterface {
    @Autowired
    VehicleRepository vehicleRepository;

    Scanner scanner = new Scanner(System.in);

//    Dealership dealership;
//    @Autowired

    public void display() {

        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1) View all vehicles");
            System.out.println("2) Search vehicles by price");
            System.out.println("3) Search vehicles by make and model");
            System.out.println("4) Search vehicles year");
            System.out.println("5) Search vehicles by color");
            System.out.println("6) Search vehicles by mileage");
            System.out.println("7) Add new vehicle");
            System.out.println("8) Delete vehicle");
            System.out.println("9) Exit");
            System.out.println();

            int response = scanner.nextInt();
            scanner.nextLine();

            switch (response) {
                case 1:
                    processGetAllVehiclesRequest();
                    break;
                case 2:
                    processGetByPriceRequest();
                    break;
                case 3:
                    processGetByMakeModelRequest();
                    break;
                case 4:
                    processGetByYearRequest();
                    break;
                case 5:
                    processGetByColorRequest();
                    break;
                case 6:
                    processGetByMileageRequest();
                    break;
                case 7:
                    processAddVehicleRequest();
                    break;
                case 8:
                    processRemoveVehicleRequest();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }

            System.out.println();
            System.out.println("Continue? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

    public void processGetByPriceRequest() {
		System.out.println("min price: ");
		int min = scanner.nextInt();
		System.out.println("max price: ");
		int max = scanner.nextInt();
		scanner.nextLine();

        List<Vehicle> vehiclePriceList = vehicleRepository.getVehiclesByPrice(min, max);
		vehiclePriceList.forEach(System.out::println);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("make: ");
        String make = scanner.nextLine();
        System.out.print("model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByMakeModel(make, model);
        vehicleList.forEach(System.out::println);
    }

    public void processGetByYearRequest() {
        System.out.print("min year: ");
        int min = scanner.nextInt();
        System.out.print("max year: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByYear(min, max);
        vehicleList.forEach(System.out::println);
    }

    public void processGetByColorRequest() {
        System.out.print("color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByColor(color);
        vehicleList.forEach(System.out::println);
    }

    public void processGetByMileageRequest() {
        System.out.print("min mileage: ");
        int min = scanner.nextInt();
        System.out.print("max mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByMileage(min, max);
        vehicleList.forEach(System.out::println);

    }

//    public void processGetByVehicleTypeRequest() {}

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();
        vehicleList.forEach(System.out::println);
    }

    public void processAddVehicleRequest() {
        System.out.print("vin:");
        String vin = scanner.nextLine();
        System.out.print("make: ");
        String make = scanner.nextLine();
        System.out.print("model: ");
        String model = scanner.nextLine();
        System.out.print("year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("color: ");
        String color = scanner.nextLine();
        System.out.print("mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, make, model, year, color, mileage, price);

        List<Vehicle> vehicleList = vehicleRepository.addVehicle(vehicle);
        System.out.println("Added vehicle");
        vehicleList.forEach(System.out::println);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Vehicle id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicleList = vehicleRepository.deleteVehicle(id);
        System.out.println("Removed vehicle");
        vehicleList.forEach(System.out::println);
    }
}
