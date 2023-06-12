package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Flight;
import com.solvdLaba.airport.entities.Passenger;

public class FlightThread implements Runnable{

    private Flight flight;

    public FlightThread(Flight flight){
        this.flight = flight;
    }
    public void run(){
        System.out.println("Flight Thread is running");
        flight.addPassenger(new Passenger("Jimmy Cho",35));
        flight.addPassenger(new Passenger("Jessica Alba",45));
    }
}