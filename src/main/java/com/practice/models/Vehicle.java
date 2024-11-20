package com.practice.models;
import com.practice.models.VehicleType;

public class Vehicle extends BaseModel {
    private String VehicleNumber;
    private VehicleType VehicleType;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        VehicleType = vehicleType;
    }
}
