package com.solvdLaba.exceptions;

import com.solvdLaba.airport.Airport;
import com.solvdLaba.airport.Flight;
import com.solvdLaba.airport.Ticket;

import java.util.Date;

public final class NoSeatAvailable extends Exception {
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Date date;

    public NoSeatAvailable(String message, Flight flight){
        super(message);
        System.out.println("Flight number: " + flight.getFlightNumber() +" doesn't have available seats");
        departureAirport = flight.getDepartureAirport();
        arrivalAirport = flight.getArrivalAirport();
        date = flight.getDate();
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
