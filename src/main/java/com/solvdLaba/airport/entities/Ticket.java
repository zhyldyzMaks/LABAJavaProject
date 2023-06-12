package com.solvdLaba.airport.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    private String ticketNumber;
    private Flight flight;
    private String seatNumber;
    private String ticketClass;
    private double ticketCost;
    private Passenger passenger;

    public Ticket(String ticketNumber, Flight flight, String seatNumber, String ticketClass, double ticketCost) {
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.ticketClass = ticketClass;
        this.ticketCost = ticketCost;
    }

    public Ticket(String ticketNumber, String seatNumber, double ticketCost) {
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.ticketCost = ticketCost;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void ticketDetails() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Class: " + ticketClass);
        System.out.println("Ticket Cost: " + ticketCost);
    }

    public Iterator<Ticket> iterator() {
        List<Ticket> tickets = new ArrayList<>();
        return tickets.iterator();
    }

    public Stream<Ticket> stream() {
        return Stream.of(this);
    }

    @Override
    public boolean equals(Object ticket) {
        if (this.toString() == ticket.toString()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.ticketNumber;
    }
}