package com.solvdLaba.customExceptions;

public class FlightNotFoundException extends Exception{
    private String flightNumber;

    public FlightNotFoundException(String flightNumber) {
        super("Flight with number " + flightNumber +" not found." );
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}