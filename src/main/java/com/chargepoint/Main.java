package com.chargepoint;

import com.chargepoint.model.Charger;
import com.chargepoint.model.ElectricMailTruck;
import com.chargepoint.scheduler.FleetScheduler;
import com.chargepoint.scheduler.SimpleSchedulingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<ElectricMailTruck> electricMailTrucks = Arrays.asList(
                new ElectricMailTruck(1, 100, 50),  // Needs 50 kWh
                new ElectricMailTruck(2, 80, 20),   // Needs 60 kWh
                new ElectricMailTruck(3, 120, 70)   // Needs 50 kWh
        );
        int hours = 2; // Available time to charge
        List<Charger> chargers = Arrays.asList(
                new Charger(1, 50, hours),  // Charges 50 kWh per hour
                new Charger(2, 30, hours)   // Charges 30 kWh per hour
        );

        // Initialize FleetScheduler with a scheduling strategy
        FleetScheduler fleetScheduler = new FleetScheduler(new SimpleSchedulingStrategy());
        // Get the schedule
        System.out.println(" Get charging Schedule for Fleet of trucks");
        Map<Integer, List<Integer>> schedule = fleetScheduler.schedule(electricMailTrucks, chargers, hours);
        // Print the schedule
        printSchedule(schedule);
    }

    public static void printSchedule(Map<Integer, List<Integer>> schedule){
        // Print the schedule
        for(Map.Entry<Integer, List<Integer>> entry : schedule.entrySet()) {
            System.out.print("Charger " + entry.getKey() + ": ");
            entry.getValue().forEach(v-> System.out.print(v+", "));
            System.out.print("\b\b\n");
        }
    }
}