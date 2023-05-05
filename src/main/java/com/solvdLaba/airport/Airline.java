package com.solvdLaba.airport;

import java.util.List;

public interface Airline {

    void addFlight(Flight flight);

    void removeFlight(Flight flight);

    List<Flight> getAllFlights();

    String getName();

    void setName(String name);
}
