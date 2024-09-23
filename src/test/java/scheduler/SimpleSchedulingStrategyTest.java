package com.chargepoint.scheduler;


import com.chargepoint.model.Charger;
import com.chargepoint.model.Truck;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class SimpleSchedulingStrategyTest {

    @Test
    public void testSimpleScheduling() {
        // Set up test data
        List<Truck> trucks = Arrays.asList(
                new Truck(1, 100, 50),  // Needs 50 kWh
                new Truck(2, 80, 20),   // Needs 60 kWh
                new Truck(3, 120, 70)   // Needs 50 kWh
        );

        List<Charger> chargers = Arrays.asList(
                new Charger(1, 50),  // Charges 50 kWh per hour
                new Charger(2, 30)   // Charges 30 kWh per hour
        );

        int hours = 2; // Available time to charge

        // Create the strategy
        SchedulingStrategy strategy = new SimpleSchedulingStrategy();

        // Run the scheduling algorithm
        Map<Integer, List<Integer>> schedule = strategy.schedule(trucks, chargers, hours);

        // Verify the schedule
        // Expectation: Charger 1 should charge Truck 1 and Truck 3; Charger 2 should charge Truck 2
        assertEquals(2, schedule.size());
        assertTrue(schedule.get(1).contains(1));  // Charger 1 should have Truck 1
        assertTrue(schedule.get(1).contains(3));  // Charger 1 should have Truck 3
        assertTrue(schedule.get(2).contains(2));  // Charger 2 should have Truck 2
    }

    @Test
    public void testWhenNoTrucksToCharge() {
        List<Truck> trucks = new ArrayList<>();
        List<Charger> chargers = Arrays.asList(
                new Charger(1, 50),
                new Charger(2, 30)
        );

        int hours = 2;

        SchedulingStrategy strategy = new SimpleSchedulingStrategy();
        Map<Integer, List<Integer>> schedule = strategy.schedule(trucks, chargers, hours);

        assertTrue(schedule.isEmpty());  // No trucks should result in an empty schedule
    }

    @Test
    public void testWhenNoChargersAvailable() {
        List<Truck> trucks = Arrays.asList(
                new Truck(1, 100, 50),
                new Truck(2, 80, 20)
        );

        List<Charger> chargers = new ArrayList<>();  // No chargers available

        int hours = 2;

        SchedulingStrategy strategy = new SimpleSchedulingStrategy();
        Map<Integer, List<Integer>> schedule = strategy.schedule(trucks, chargers, hours);

        assertTrue(schedule.isEmpty());  // No chargers should result in an empty schedule
    }
}