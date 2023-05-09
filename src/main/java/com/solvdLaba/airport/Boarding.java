package com.solvdLaba.airport;

import com.solvdLaba.exceptions.InvalidBoardingPassException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boarding implements BoardingGate{
    private boolean gateOpen;
    private static List<Passenger> passengersOnBoard;
    private int boardingNumber;

    public int getBoardingNumber() {
        return boardingNumber;
    }

    public void checkIn(Passenger passenger){
        passenger.setBoardingPass(this);
    }

    public void setBoardingNumber(int boardingNumber) {
        this.boardingNumber = boardingNumber;
    }

    public Boarding() {
        gateOpen = false;
        boardingNumber = new Random().nextInt(10000);
        passengersOnBoard = new ArrayList<Passenger>();
    }

    public void openGate() {
        gateOpen = true;
        System.out.println("Boarding gate is now open.");
    }
    public void closeGate() {
        gateOpen = false;
        System.out.println("Boarding gate is now closed.");
    }

    public void boardPassengers(List<Passenger> passengers) throws InvalidBoardingPassException {
        if (!this.gateOpen) {
            System.out.println("Boarding gate is closed. Cannot board passengers.");
            return;
        }

        for (Passenger passenger : passengers) {
            if (!passenger.hasValidBoardingPass(passenger)) {
                System.out.println("Passenger " + passenger.getName() + " does not have a valid boarding pass. Skipping.");
                continue;
            }

            this.passengersOnBoard.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " has been boarded onto the flight.");
        }
    }
    public List<Passenger> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public String toString(){
        return getPassengersOnBoard().toString();
    }
}
