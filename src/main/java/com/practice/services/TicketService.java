package com.practice.services;

import com.practice.models.*;
import com.practice.models.ParkingLot;
import com.practice.models.Ticket;
import com.practice.models.VehicleType;
import com.practice.repositories.GateRepository;
import com.practice.repositories.ParkingLotRepository;
import com.practice.repositories.TicketRepository;
import com.practice.repositories.VehicleRepository;
import com.practice.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                         TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public Ticket GenerateTicket(
            VehicleType vehicleType,
            Long gateId,
            String vehicleNumber
    )
    {
        //the servie has received the input for generating ticket
        //now we will create ticket object
        //get gate object from gateid
        //get vehicle object from vehicle number from repo
        //get parkingspot which is empty for this particular vehicle type in this parkinglot
        Optional<Gate> gateOp = gateRepository.findGateById(gateId);
        Gate gate;
        if(gateOp.isEmpty()) {
            return null;
        }
        else gate = gateOp.get();
        Optional<Vehicle> optionalVehicle  = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if(optionalVehicle.isEmpty())
        {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.SaveVehicle(vehicle);
        }
        else
        {
            vehicle = optionalVehicle.get();
        }
        //get parkingspot which is empty for this particular vehicle type in this parkinglot
        //first find this parking lot
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
        if (parkingLot.isEmpty()) {
            return null;
        }
        ParkingSpot parkingSpot = spotAssignmentStrategy.findEmptySpot(parkingLot.get(), vehicleType);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryGate(gate);
        return ticketRepository.SaveTicket(ticket);
    }
}
