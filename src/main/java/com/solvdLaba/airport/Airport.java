package com.solvdLaba.airport;

import java.util.List;

public abstract class Airport {
    protected String name;
    protected String location;

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public abstract void displayDetails();


}
