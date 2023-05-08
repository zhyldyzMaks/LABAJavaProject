package com.solvdLaba.airport;

import java.util.ArrayList;
import java.util.List;

public class Airline {

   private String airlineName;
   private List<Flight> flights;

   public Airline(String name){
       airlineName = name;
       this.flights = new ArrayList<>();
   }
    public String getName() {
        return airlineName;
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
