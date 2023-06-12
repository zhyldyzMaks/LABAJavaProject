package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.GateStatus;
import com.solvdLaba.airport.entities.Passenger;

import java.util.List;

public interface BoardingGate {

    GateStatus getGateStatus();

    void openGate();

    void closeGate();

    void boardPassengers(List<Passenger> passengers);
}