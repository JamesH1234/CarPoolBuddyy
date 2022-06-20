package com.example.carpoolbuddyy.Models.Vehicles;

import java.util.ArrayList;

public class Bicycle extends Vehicle {

    private int weight;
    private int weightCapacity;

    public Bicycle() {

    }

    public Bicycle(String owner, String model, int capacity, double basePrice, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int weight, int weightCapacity) {
        super(owner, model, capacity, basePrice, vehicleID, ridersUIDs, open, vehicleType);
        this.weight = weight;
        this.weightCapacity = weightCapacity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "weight=" + weight +
                ", weightCapacity=" + weightCapacity +
                '}';
    }
}
