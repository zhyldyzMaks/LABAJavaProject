package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Airport;
import com.solvdLaba.airport.entities.GateStatus;
import org.apache.logging.log4j.util.Supplier;

public class GateService {

    private Airport airport;
    private GateStatus status;
    private String gateNumber;

    public GateService(Airport airport, String gateNumber, GateStatus status) {
        this.airport = airport;
        this.gateNumber = gateNumber;
        this.status = status;
    }

    public static String generateGateNumber() {
        Supplier<String> gateNumberSupplier = () -> "Gate-" + (int) (Math.random() * 10);
        return gateNumberSupplier.get();
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}