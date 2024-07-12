package com.example.CarDealershipSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealership {
    private int dealershipId;
    private String name;
    private String address;
    private String phone;
}
