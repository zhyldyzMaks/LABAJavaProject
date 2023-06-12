package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Airport;
import com.solvdLaba.airport.entities.GateStatus;
import com.solvdLaba.airport.utils.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

final public class DomesticAirport extends Airport {

    private List<GateService> gates = new ArrayList<>();

    public DomesticAirport(String name, String location) {
        super(name, location);
        MyLogger.info("Airport getting created: " + name);
    }

    static{
        System.out.println("Running Static Block");
    }

    public void addGate(GateService gate) {
        gates.add(gate);
    }

    public void closeAllGates() {
        for (GateService gate : gates) {
            gate.setStatus(GateStatus.CLOSED);
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

    public List<String> getGateNumbers(Function<GateService, String> gateNumberMapper) {
        List<String> gateNumbers = new ArrayList<>();
        for (GateService gate : gates) {
            String gateNumber = gateNumberMapper.apply(gate);
            gateNumbers.add(gateNumber);
        }
        return gateNumbers;
    }

    public List<GateService> getGatesMatching(Predicate<GateService> gatePredicate) {
        List<GateService> matchingGates = new ArrayList<>();
        for (GateService gate : gates) {
            if (gatePredicate.test(gate)) {
                matchingGates.add(gate);
            }
        }
        return matchingGates;
    }
}