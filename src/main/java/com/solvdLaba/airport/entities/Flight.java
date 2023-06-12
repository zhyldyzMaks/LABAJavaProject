package com.solvdLaba.airport.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {

    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int numberOfSeats;
    public int availableSeats;
    private Date date;
    private String duration;
    private Airplane airplane;
    private Terminal depTerminal;
    private Terminal arrTerminal;
    private List<Passenger> passengers = new ArrayList<>();
    private FlightState flightState;

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport, int numberOfSeats, Date date,
                  String duration, Terminal depTerminal, Terminal arrTerminal) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.numberOfSeats = numberOfSeats;
        this.availableSeats = numberOfSeats;
        this.date = date;
        this.duration = duration;
        this.depTerminal = depTerminal;
        this.arrTerminal = arrTerminal;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getAvailableSeats(String preferredClass) {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Terminal getDepTerminal() {
        return depTerminal;
    }

    public void setDepTerminal(Terminal depTerminal) {
        this.depTerminal = depTerminal;
    }

    public Terminal getArrTerminal() {
        return arrTerminal;
    }

    public void setArrTerminal(Terminal arrTerminal) {
        this.arrTerminal = arrTerminal;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public FlightState getFlightState() {
        return flightState;
    }

    public void setFlightState(FlightState flightState) {
        this.flightState = flightState;
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    @Override
    public String toString() {
        return "FlightE{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", numberOfSeats=" + numberOfSeats +
                ", availableSeats=" + availableSeats +
                ", date=" + date +
                ", duration='" + duration + '\'' +
                ", airplane=" + airplane +
                ", depTerminal=" + depTerminal +
                ", arrTerminal=" + arrTerminal +
                ", passengers=" + passengers +
                ", flightState=" + flightState +
                '}';
    }
}