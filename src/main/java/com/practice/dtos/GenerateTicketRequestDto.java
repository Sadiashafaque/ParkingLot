package com.practice.dtos;

import com.practice.models.VehicleType;

public class GenerateTicketRequestDto {//what isend
    //to controller
    //vehicle type
    //gate id
    //vehicle number
    private VehicleType vehicleType;
    private String vehicleNumber;
    private Long gateId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
