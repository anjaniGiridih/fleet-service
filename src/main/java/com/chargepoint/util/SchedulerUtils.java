package com.chargepoint.util;

public class SchedulerUtils {

    /**
     * Sample calculation
     *  Charging rate= 50Kw/hr
     *  total charge required = 100Kw
     *  50kw charged in 1 hr
     *  1Kw charged in 1/50kw
     *  100Kw charged in 1/50 * 100 Hr = 2hr
     */
    public double timeConsumedForCharging(double chargeRate, double totalChargeRequired){
        return totalChargeRequired/chargeRate;
    }
}
