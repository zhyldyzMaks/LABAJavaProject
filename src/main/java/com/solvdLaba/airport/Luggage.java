package com.solvdLaba.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Luggage {
    private int weight;
    private String type;

    public Luggage(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
    public String toString(){
        return "Baggage Details: \n Weight: "+weight+" kg"+"\n Type: "+type;
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

}
