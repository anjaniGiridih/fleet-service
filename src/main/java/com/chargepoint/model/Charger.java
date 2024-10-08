package com.chargepoint.model;


import java.util.Objects;

public class Charger {
    private int id;
    private double chargingRate;  // in kW
    private double remainingTime;// initial hours specified and remaining after charging each Electric truck

    public Charger(int id, double chargingRate, double remainingTime) {
        this.id = id;
        this.chargingRate = chargingRate;
        this.remainingTime = remainingTime;
    }

    public int getId() {
        return id;
    }

    public double getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }

    public double getChargingRate() {
        return this.chargingRate;
    }

    public double getAvailableCapacityToCharge(){
        return getChargingRate()*getRemainingTime();
    }

    @Override
    public String toString() {
        return "Charger{" + "id=" + id +
                ", rate=" + chargingRate +
                ", remainingTime=" + remainingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charger charger = (Charger) o;
        return id == charger.id && Double.compare(chargingRate, charger.chargingRate) == 0 && Double.compare(remainingTime, charger.remainingTime) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chargingRate, remainingTime);
    }

}