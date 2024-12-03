package com.practice.strategies.feecalculationstrategy;

import com.practice.models.VehicleType;

public class VehicleDurationFeeCalculationStrategy implements FeeCalculationStrategy{

    @Override
    public int calculateFee(int durationInMinutes) {
        return 100*durationInMinutes;
    }
}
