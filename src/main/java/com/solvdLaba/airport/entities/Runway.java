package com.solvdLaba.airport.entities;

public enum Runway {
    OPEN("Open"),
    CLOSED("Closed"),
    UNDER_CONSTRUCTION("Under construction"),
    MAINTENANCE("Under maintenance");

    private final String status;

    Runway(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}