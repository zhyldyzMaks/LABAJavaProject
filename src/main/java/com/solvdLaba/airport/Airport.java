package com.solvdLaba.airport;

abstract class Airport {
    protected String airportName;
    protected String airportLocation;

    public Airport(String name, String location) {
        airportName = name;
        airportLocation = location;
    }

    public abstract void displayDetails();
}
