package com.solvdLaba.airport;

import com.solvdLaba.utils.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final public class DomesticAirport extends Airport{
    private List<Gate> gates = new ArrayList<>();
    public DomesticAirport(String name, String location) {
        super(name, location);
        MyLogger.info("Airport getting created: " + name);
    }
    static{
        System.out.println("Running Static Block");
    }
    public void closeAllGates() {
        for (Gate gate : gates) {
            gate.setStatus(GateStatus.GATE_CLOSE);
        }
    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DomesticAirport)) {
            return false;
        }
        DomesticAirport other = (DomesticAirport) obj;
        return Objects.equals(name, other.name) && Objects.equals(location, other.location);
    }

    public void displayDetails() {
        System.out.println("Domestic Airport - Name: " + name + ", Location: " + location);
    }

    @Override
    public String toString(){
        return this.name;
    }

}
