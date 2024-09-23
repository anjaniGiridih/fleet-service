package com.chargepoint.model;


public class Charger {
    private int id;
    private double rate;  // in kW

    public Charger(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Charger{" +
                "id=" + id +
                ", rate=" + rate +
                '}';
    }
}