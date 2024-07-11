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

            vehicles = queryVehicles(ps);
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

            vehicles = queryVehicles( ps);
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

            vehicles = queryVehicles(ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        String query = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, minYear);
            ps.setInt(2, maxYear);
            vehicles = queryVehicles(ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        String query = "SELECT * FROM vehicles WHERE LOWER(color) = LOWER(?)";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, color);
            vehicles = queryVehicles(ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        String query = "SELECT * FROM vehicles WHERE mileage >= ? AND mileage <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, minMileage);
            ps.setInt(2, maxMileage);
            vehicles = queryVehicles(ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO vehicles (vin, make, model, year, color, mileage, price) VALUES (?, ?, ?, ?, ?, " +
                "?, ?) RETURNING *";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, vehicle.getVin());
            ps.setString(2, vehicle.getMake());
            ps.setString(3, vehicle.getModel());
            ps.setInt(4, vehicle.getYear());
            ps.setString(5, vehicle.getColor());
            ps.setInt(6, vehicle.getMileage());
            ps.setDouble(7, vehicle.getPrice());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int vehicleId = rs.getInt("vehicle_id");
                    String vin = rs.getString("vin");
                    boolean sold = rs.getBoolean("sold");
                    String make = rs.getString("make");
                    String model = rs.getString("model");
                    int year = rs.getInt("year");
                    String color = rs.getString("color");
                    int mileage = rs.getInt("mileage");
                    double price = rs.getDouble("price");

                    Vehicle newVehicle = new Vehicle(vehicleId, vin, sold, make, model, year, color, mileage, price);
                    vehicles.add(newVehicle);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> deleteVehicle(int id) {
        String query = "DELETE FROM vehicles WHERE vehicle_id = ? RETURNING *";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            vehicles = queryVehicles(ps);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Helpers
    private List<Vehicle> queryVehicles(PreparedStatement ps) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
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
