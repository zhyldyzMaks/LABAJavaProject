package com.solvdLaba.airport;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int numberOfSeats;
    protected int availableSeats;
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
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    @Override
    public String toString(){
        return "Flight Information\nFlight number: "+flightNumber+"\nDeparture from: "+getDepartureAirport()
                + "\nArrive to : "+getArrivalAirport() +"\nNumber of seats "+ numberOfSeats+" seats"
                +"\nAvailable seats are : "+availableSeats + "\nDate: " + date + "\nDuration: " + duration
                +"\nDeparture Terminal is: "+getDepTerminal().getName() + "\nArrival Terminal: " +getArrTerminal().getName();
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
    public int getAvailableSeats(String preferredClass) {
        return availableSeats;
    }
    public Date getDate() {
        return date;}

    public int getAvailableSeats() {
        return availableSeats;}

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getDuration() {
        return duration;}

    public Airplane getAirplane() {
        return airplane;}

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
        System.out.println(getPassengers().toString());
        return passengers;
    }

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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }


    public void setFlightState(FlightState state) {
        flightState = state;
    }
    public Stream<Passenger> getPassengerStream() {
        return passengers.stream();
    }
    public void printPassengerNames() {
        passengers.stream()
                .map(Passenger::getName)
                .forEach(System.out::println);
    }
    public long countAdultPassengers() {
        return passengers.stream()
                .filter(p -> p.getAge() >= 18)
                .count();
    }
    public Stream<Passenger> getPassengersWithLuggage() {
        return passengers.stream()
                .filter(p -> p.getLuggage() != null);
    }
    public boolean hasPassenger(String passengerName) {
        return passengers.stream()
                .anyMatch(p -> p.getName().equals(passengerName));
    }
    public boolean allPassengersCheckedIn() {
        return passengers.stream()
                .allMatch(Passenger::isTSAChecked);
    }

}
