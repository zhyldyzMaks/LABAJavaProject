package com.solvdLaba.airport;

import java.util.List;

public interface BoardingGate {
    void openGate(); // opens the boarding gate
    void closeGate(); // closes the boarding gate
    boolean isGateOpen(); // checks if the boarding gate is open
    void boardPassengers(List<Passenger> passengers); // boards a list of passengers onto the flight
    List<Passenger> getPassengersOnBoard(); // returns a list of passengers currently on board the flight

}
