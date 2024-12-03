package com.practice.strategies.spotassignmentstrategy;

import com.practice.models.ParkingLot;
import com.practice.models.ParkingSpot;
import com.practice.models.VehicleType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot findEmptySpot(ParkingLot parkingLot, VehicleType vehicleType) {
        return null;
    }
}
