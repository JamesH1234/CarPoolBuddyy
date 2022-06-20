package com.example.carpoolbuddyy.Models.Vehicles;

import java.util.ArrayList;

public class Segway extends Vehicle {

    private int range;
    private int weightCapacity;

    public Segway() {

    }

    public Segway(String owner, String model, int capacity, double basePrice, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int range, int weightCapacity) {
        super(owner, model, capacity, basePrice, vehicleID, ridersUIDs, open, vehicleType);
        this.range = range;
        this.weightCapacity = weightCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        return "Segway{" +
                "range=" + range +
                ", weightCapacity=" + weightCapacity +
                '}';
    }
}
