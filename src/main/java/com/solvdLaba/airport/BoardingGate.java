package com.solvdLaba.airport;

import com.solvdLaba.exceptions.InvalidBoardingPassException;

import java.util.List;

public interface BoardingGate {

    void boardPassengers(List<Passenger> passengers) throws InvalidBoardingPassException;
    List<Passenger> getPassengersOnBoard();

}
