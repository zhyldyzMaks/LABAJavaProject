package com.solvdLaba.airport;

import com.solvdLaba.utils.MyLogger;

final public class DomesticAirport extends Airport{
    public DomesticAirport(String name, String location) {
        super(name, location);
        //MyLogger.info("Airport getting created: " + name);
    }
    static{
        System.out.println("Running Static Block");
    }

    public void displayDetails() {
        System.out.println("Domestic Airport - Name: " + airportName + ", Location: " + airportLocation);
    }

    @Override
    public String toString(){
        return this.airportName;
    }

}
