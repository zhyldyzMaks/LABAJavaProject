package com.solvdLaba.airport.entities;

import java.util.List;

public abstract class Airport {

    public String name;
    protected String location;

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public abstract void displayDetails();
}