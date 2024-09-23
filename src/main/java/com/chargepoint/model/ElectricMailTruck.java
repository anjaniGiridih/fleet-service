package com.chargepoint.model;

public class ElectricMailTruck {
    private int id;
    private double capacity;  // in kWh
    private double currentCharge; // in kWh

    public ElectricMailTruck(int id, double capacity, double currentCharge) {
        this.id = id;
        this.capacity = capacity;
        this.currentCharge = currentCharge;
    }

    public double getRequiredCharge() {
        return capacity - currentCharge;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", requiredCharge=" + getRequiredCharge() +
                '}';
    }
}