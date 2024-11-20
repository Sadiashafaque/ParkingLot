package com.practice.repositories;

import com.practice.models.Vehicle;

import java.util.*;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicles = new HashMap<>();
    private long lastSavedId = 0L;
    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber)
    {
        for(Vehicle vehicle : vehicles.values())
        {
            if(vehicle.getVehicleNumber().equals(vehicleNumber))
            {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
    public Vehicle SaveVehicle(Vehicle vehicle)
    {
        lastSavedId++;
        vehicle.setId(lastSavedId);
        vehicles.put(lastSavedId,vehicle);
        return vehicle;
    }

}
