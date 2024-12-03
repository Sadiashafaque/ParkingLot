package com.practice.services;

import com.practice.models.Bill;
import com.practice.models.Payment;
import com.practice.models.PaymentMode;
import com.practice.models.Ticket;
import com.practice.strategies.feecalculationstrategy.FeeCalculationStrategy;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class BillService {
    private FeeCalculationStrategy feeCalculationStrategy;
    public BillService(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
    public Bill GenerateBill(Ticket ticket,
                             List<Payment> payments)
    {
        //generate bill object
        //calculate amount
        Bill bill = new Bill();
        bill.setPaymentList(payments);
        bill.setExitTime(new Date());
        bill.setTicket(ticket);
        Instant instantEntry = ticket.getEntryTime().toInstant();
        Instant instantExit = bill.getExitTime().toInstant();
        Duration duration = Duration.between(instantEntry, instantExit);
        bill.setAmount(feeCalculationStrategy.calculateFee((int)duration.toMinutes()));
        return bill;
    }

}
