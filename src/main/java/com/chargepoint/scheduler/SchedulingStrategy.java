package com.chargepoint.scheduler;


import com.chargepoint.model.Charger;
import com.chargepoint.model.ElectricMailTruck;

import java.util.List;
import java.util.Map;

public interface SchedulingStrategy {
    // Method that all scheduling algorithms will implement
    Map<Integer, List<Integer>> schedule(List<ElectricMailTruck> electricMailTrucks, List<Charger> chargers, int hours);

}