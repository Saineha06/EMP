package com.neoteric.ticket;

import org.junit.jupiter.api.Test;

public class TicketTest {
    @Test
    public void Ticket(){
        Ticket ticket= new Ticket();
        ticket.movieName="Robo";
        ticket.phoneNumber=123455;
        ticket.Price=1500;
        ticket.SeatNumber="A15";
        System.out.println(ticket);


    }
}
