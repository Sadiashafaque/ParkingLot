package com.practice.repositories;

import com.practice.models.ParkingSpot;
import com.practice.models.Ticket;

import java.util.*;


public class TicketRepository {
    private Map<Long, Ticket> tickets = new HashMap<Long, Ticket>();
    private long lastSavedTicketId = 0L;

    public Ticket SaveTicket(Ticket ticket)
    {
        lastSavedTicketId++;
        ticket.setId(lastSavedTicketId);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }


}
