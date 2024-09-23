package com.chargepoint.scheduler;


import com.chargepoint.model.Charger;
import com.chargepoint.model.ElectricMailTruck;
import com.chargepoint.util.SchedulerUtils;

import java.util.*;

public class SimpleSchedulingStrategy implements SchedulingStrategy {
    private SchedulerUtils schedulerUtils = new SchedulerUtils();
    @Override
    public Map<Integer, List<Integer>> schedule(List<ElectricMailTruck> electricMailTrucks, List<Charger> chargers, int hours) {
        if(electricMailTrucks.isEmpty() || chargers.isEmpty()){
            System.out.println("Either Truck or Charger is not available");
            throw new IllegalArgumentException("Truck or charger list can't be null");
        }
        if(hours<=0){
            throw new IllegalArgumentException("charge time must be greater than 0");
        }
        Map<Integer, List<Integer>> schedule = new HashMap<>();

        // Sort trucks by the amount of time they need to get fully charged (smallest first)
        electricMailTrucks.sort(Comparator.comparingDouble(ElectricMailTruck::getRequiredCharge));

        // Sort chargers by their charging rate (highest first)
        chargers.sort(Comparator.comparingDouble(Charger::getAvailableCapacityToCharge));

        for (ElectricMailTruck electricMailTruck : electricMailTrucks) {
            for (Charger charger : chargers) {
                double requiredCharge = electricMailTruck.getRequiredCharge();
                double maxChargePossible = charger.getAvailableCapacityToCharge();

                // If the truck can be fully charged, assign it to the charger
                if (requiredCharge <= maxChargePossible) {
                    // reducing time from current charger after charging the truck
                    charger.setRemainingTime(charger.getRemainingTime() - schedulerUtils.timeConsumedForCharging(charger.getChargingRate(),requiredCharge));
                    schedule.computeIfAbsent(charger.getId(), k -> new ArrayList<>()).add(electricMailTruck.getId());
                    break;  // Move to the next truck once scheduled
                }
            }
        }

        return schedule;
    }
}