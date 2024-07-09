package com.example.CarDealershipSpring.repositories;

import com.example.CarDealershipSpring.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource dataSource;

    public List<Vehicle> getAllVehicles() {
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int vehicleId = rs.getInt("vehicle_id");
                String vin = rs.getString("vin");
                boolean sold = rs.getBoolean("sold");
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                int mileage = rs.getInt("mileage");
                double price = rs.getDouble("price");

                Vehicle vehicle = new Vehicle(vehicleId, vin, sold, make, model, year, color, mileage, price);
                vehicles.add(vehicle);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
