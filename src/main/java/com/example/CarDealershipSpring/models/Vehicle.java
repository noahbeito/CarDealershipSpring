package com.example.CarDealershipSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int vehicleId;
    private String vin;
    private boolean sold;
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private double price;
}
