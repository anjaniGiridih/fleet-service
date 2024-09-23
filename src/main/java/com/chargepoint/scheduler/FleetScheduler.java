package com.chargepoint.scheduler;


import com.chargepoint.model.Charger;
import com.chargepoint.model.ElectricMailTruck;

import java.util.List;
import java.util.Map;

public class FleetScheduler {
    private SchedulingStrategy strategy;

    // Constructor that accepts a scheduling strategy
    public FleetScheduler(SchedulingStrategy strategy) {
        this.strategy = strategy;
    }

    // Method to run the scheduler with the chosen strategy
    public Map<Integer, List<Integer>> schedule(List<ElectricMailTruck> electricMailTrucks, List<Charger> chargers, int hours) {
        return strategy.schedule(electricMailTrucks, chargers, hours);
    }
}