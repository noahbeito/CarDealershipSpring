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

            return queryVehicles(vehicles, ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        String query = "SELECT * FROM vehicles WHERE price >= ? AND price <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);

            return queryVehicles(vehicles, ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }



    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        String query = "SELECT * FROM vehicles WHERE LOWER(make) = LOWER(?) AND LOWER(model) = LOWER(?)";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn =  dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, make);
                    ps.setString(2, model);

            return queryVehicles(vehicles, ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Helpers
    private List<Vehicle> queryVehicles(List<Vehicle> vehicles, PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
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
        return vehicles;
    }
}
