package com.solvdLaba.airport.services;
import com.solvdLaba.airport.entities.Boarding;
import com.solvdLaba.airport.entities.GateStatus;
import com.solvdLaba.airport.entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public class BoardingService implements BoardingGate{

    private Boarding boarding;
    private GateStatus gateStatus;
    private List<Passenger> passengersOnBoard;

    public BoardingService() {
        boarding = new Boarding();
        gateStatus = GateStatus.CLOSED;
        passengersOnBoard = new ArrayList<>();
    }

    public int getBoardingNumber() {
        return boarding.getBoardingNumber();
    }

    public void setBoardingNumber(int boardingNumber) {
        boarding.setBoardingNumber(boardingNumber);
    }

    @Override
    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public List<Passenger> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public void addPassenger(Passenger passenger) {
        passengersOnBoard.add(passenger);
    }

    public void checkIn(Passenger passenger) {
        passenger.setBoardingPass(boarding);
    }

    @Override
    public void openGate() {
        gateStatus = GateStatus.OPEN;
        System.out.println("Boarding gate is now open.");
    }

    @Override
    public void closeGate() {
        gateStatus = GateStatus.CLOSED;
        System.out.println("Boarding gate is now closed.");
    }

    public void boardPassengers(List<Passenger> passengers) {
        if (gateStatus != GateStatus.OPEN) {
            System.out.println("Boarding gate is closed. Cannot board passengers.");
            return;
        }

        for (Passenger passenger : passengers) {
            passengersOnBoard.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " has been boarded onto the flight.");
        }
    }
}