package com.example.CarDealershipSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInterface {
    Dealership dealership;

    public void display() {

    }

    public void processGetByPriceRequest() {}

    public void processGetByMakeModelRequest() {}

    public void processGetByYearRequest() {}

    public void processGetByColorRequest() {}

    public void processGetByMileageRequest() {}

    public void processGetByVehicleTypeRequest() {}

    public void processGetAllVehiclesRequest() {}

    public void processAddVehicleRequest() {}

    public void processRemoveVehicleRequest() {}
}
