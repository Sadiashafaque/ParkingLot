package com.practice.controllers;

import com.practice.dtos.GenerateTicketRequestDto;
import com.practice.models.Ticket;
import com.practice.models.VehicleType;
import com.practice.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public void GenerateTicket(GenerateTicketRequestDto requestDto)
    {
        VehicleType vehicleType = requestDto.getVehicleType();
        Long gateId = requestDto.getGateId();
        String vehicleNumber = requestDto.getVehicleNumber();
        Ticket ticket = ticketService.GenerateTicket(vehicleType, gateId, vehicleNumber);

    }
}
