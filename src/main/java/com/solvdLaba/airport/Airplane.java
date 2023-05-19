package com.solvdLaba.airport;

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
    public String toString()
    {
        return "Airplane Information\nAircraft: "+getType()+" "+getModel()+"\nCapacity: "+getCapacity()
                +" seats"+"\nPilot: "+pilot;
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

}
