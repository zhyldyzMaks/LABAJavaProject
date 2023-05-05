package com.solvdLaba.airport;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int numberOfSeats;
    protected int availableSeats;
    Airplane airplane;
    private Date date;

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Date getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    private String duration;

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport, int numberOfSeats, Date date, String duration) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.numberOfSeats = numberOfSeats;
        this.availableSeats = numberOfSeats;
        this.date = date;
        this.duration = duration;
    }
    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getAvailableSeats(String preferredClass) {
        return availableSeats;
    }


    @Override
    public String toString(){
        return "Flight Information\nFlight number: "+flightNumber+"\nDeparture from: "+getDepartureAirport()
                + "\nArrive to : "+getArrivalAirport() +"\nNumber of seats "+ numberOfSeats+" seats"
                +"\nAvailable seats are : "+availableSeats + " \nDate: " + date + "\nDuration: " + duration;
    }

}
