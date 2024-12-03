package com.practice.strategies.feecalculationstrategy;

import com.practice.models.VehicleType;

public interface FeeCalculationStrategy {
    public int calculateFee(int duration);
}
