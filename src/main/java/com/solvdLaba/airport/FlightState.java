package com.solvdLaba.airport;

public enum FlightState {

    SCHEDULED,
    GATE_OPEN,
    GATE_CLOSE,
    START_REGISTERING,
    START_BOARDING,
    START_GATING,
    IN_FLIGHT,
    ARRIVED,
    DELAYED,
    CANCELED;

    public void setFlightState(Flight flight) {
        flight.setFlightState(this);
    }
}
