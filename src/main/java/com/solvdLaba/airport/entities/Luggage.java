package com.solvdLaba.airport.entities;

import com.solvdLaba.airport.services.LuggageFilter;

public class Luggage {

    private int weight;
    private String type;

    public Luggage(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public static LuggageFilter isOverweightFilter() {
        return luggage -> luggage.getWeight() >= 20;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Baggage Details: \n Weight: " + weight + " kg" + "\n Type: " + type;
    }
}