package com.solvdLaba.airport;

import com.solvdLaba.exceptions.FlightNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Airline {

   private String name;
   private List<Flight> flights;

   public Airline(String name){
       this.name = name;
       this.flights = new ArrayList<>();
   }
    public int hashCode() {
        int result = 2;
        for (Flight flight : flights) {
            result += flight.hashCode();
        }
        return result;
    }
    public String getName() {
        return name;
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    public Flight findFlight(String flightNumber) throws FlightNotFoundException {
        return flights.stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElseThrow(() -> new FlightNotFoundException(flightNumber));
    }
}
