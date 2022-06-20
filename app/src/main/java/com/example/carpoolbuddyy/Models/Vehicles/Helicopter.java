package com.example.carpoolbuddyy.Models.Vehicles;

import java.util.ArrayList;

public class Helicopter extends Vehicle {

    private int maxAltitude;
    private int maxAirSpeed;

    public Helicopter() {

    }

    public Helicopter(String owner, String model, int capacity, double basePrice, String vehicleID, ArrayList<String> ridersUIDs, boolean open, String vehicleType, int maxAltitude, int maxAirSpeed) {
        super(owner, model, capacity, basePrice, vehicleID, ridersUIDs, open, vehicleType);
        this.maxAltitude = maxAltitude;
        this.maxAirSpeed = maxAirSpeed;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAirSpeed() {
        return maxAirSpeed;
    }

    public void setMaxAirSpeed(int maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "maxAltitude=" + maxAltitude +
                ", maxAirSpeed=" + maxAirSpeed +
                '}';
    }
}
