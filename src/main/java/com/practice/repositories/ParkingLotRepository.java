package com.practice.repositories;

import com.practice.models.Gate;
import com.practice.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLots = new HashMap<Long, ParkingLot>();

    public Optional<ParkingLot> getParkingLotFromGate(Gate gate)
    {
        for(ParkingLot parkingLot : parkingLots.values())
        {
            if(parkingLot.getGates().contains(gate))
            {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
