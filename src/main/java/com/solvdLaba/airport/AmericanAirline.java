package com.solvdLaba.airport;

import java.util.ArrayList;
import java.util.List;

public class AmericanAirline implements Airline{

    private String name;
    private List<Flight> flightList = new ArrayList<>();


    @Override
    public void addFlight(Flight flight) {
        flightList.add(flight);
    }


    @Override
    public void removeFlight(Flight flight) {
        flightList.remove(flight);
    }


    @Override
    public List<Flight> getAllFlights() {
        return flightList;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public void addFlightToList(Flight flight) {
        flightList.add(flight);
    }
}
