package com.neoteric.ticket;

public class Ticket {
    public String movieName;

    public String SeatNumber ;

    public int Price;

    public  int phoneNumber;

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                ", SeatNumber='" + SeatNumber + '\'' +
                ", Price=" + Price +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
