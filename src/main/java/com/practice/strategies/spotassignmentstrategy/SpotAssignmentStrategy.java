package com.practice.strategies.spotassignmentstrategy;

import com.practice.models.ParkingLot;
import com.practice.models.ParkingSpot;
import com.practice.models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot findEmptySpot(ParkingLot parkingLot, VehicleType vehicleType);
}
