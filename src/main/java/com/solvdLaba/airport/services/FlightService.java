package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Flight;
import com.solvdLaba.airport.entities.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public Flight findFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElse(null);
    }

    public Stream<Passenger> getPassengerStream(Flight flight) {
        return flight.getPassengers().stream();
    }

    public void printPassengerNames(Flight flight) {
        flight.getPassengers().stream()
                .map(Passenger::getName)
                .forEach(System.out::println);
    }

    public long countAdultPassengers(Flight flight) {
        return flight.getPassengers().stream()
                .filter(p -> p.getAge() >= 18)
                .count();
    }

    public Stream<Passenger> getPassengersWithLuggage(Flight flight) {
        return flight.getPassengers().stream()
                .filter(p -> p.getLuggage() != null);
    }

    public boolean hasPassenger(Flight flight, String passengerName) {
        return flight.getPassengers().stream()
                .anyMatch(p -> p.getName().equals(passengerName));
    }

    public boolean allPassengersCheckedIn(Flight flight) {
        return flight.getPassengers().stream()
                .allMatch(Passenger::isTSAChecked);
    }
}