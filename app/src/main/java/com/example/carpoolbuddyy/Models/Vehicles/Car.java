package com.example.carpoolbuddyy.Models.Vehicles;

import java.util.ArrayList;

public class Car extends Vehicle {

    private int range;

    public Car() {

    }

    public Car(String owner, String model, int capacity, double basePrice, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int range) {
        super(owner, model, capacity, basePrice, vehicleID, ridersUIDs, open, vehicleType);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Car{" +
                "range=" + range +
                '}';
    }
}
