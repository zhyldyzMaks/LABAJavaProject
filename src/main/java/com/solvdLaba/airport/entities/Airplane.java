package com.solvdLaba.airport.entities;

import java.util.Objects;

public class Airplane {

    private String type;
    private int model;
    private int capacity;
    private String pilot;

    public Airplane(String tp, int mdl, int cp, String plt)
    {
        type = tp;
        model = mdl;
        capacity = cp;
        pilot = plt;
    }
    public int hashCode() {
        int result = 31;
        result = 31 * result + Objects.hashCode(type);
        return result;
    }
    public  String getType()
    {
        return type;
    }
    public int getModel()
    {
        return model;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public void setPilot(String pilotName)
    {
        pilot = pilotName;
    }
    @Override
    public String toString() {
        return "Airplane{" +
                "type='" + type + '\'' +
                ", model=" + model +
                ", capacity=" + capacity +
                ", pilot='" + pilot + '\'' +
                '}';
    }
}