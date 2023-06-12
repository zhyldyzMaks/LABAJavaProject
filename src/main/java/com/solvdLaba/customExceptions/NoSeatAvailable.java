package com.solvdLaba.customExceptions;

import com.solvdLaba.airport.entities.Airport;
import com.solvdLaba.airport.entities.Flight;

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

    public void printStackTrace() {
        super.printStackTrace();
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