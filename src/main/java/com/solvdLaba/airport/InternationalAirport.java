package com.solvdLaba.airport;

final public class InternationalAirport extends Airport{
    public InternationalAirport(String name, String location) {
        super(name, location);
    }

    public void displayDetails() {
        System.out.println("International Airport - Name: " + airportName + ", Location: " + airportLocation);
    }

    @Override
    public String toString(){
        return this.airportName;
    }
}
