package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Airport;

final public class InternationalAirport extends Airport {

    public InternationalAirport(String name, String location) {
        super(name, location);
    }

    public void displayDetails() {
        System.out.println("International Airport - Name: " + name + ", Location: " + location);
    }

    public final void announceDeparture() {
        System.out.println("International flight departing from " + name + " airport.");
    }

    @Override
    public String toString(){
        return this.name;
    }
}