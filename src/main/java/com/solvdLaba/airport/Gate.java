package com.solvdLaba.airport;

public class Gate {

    Airport airport;
    private String gateNumber;
    private GateStatus status;

    public Gate(Airport airport, String gateNumber, GateStatus status) {
        this.airport = airport;
        this.gateNumber = gateNumber;
        this.status = status;
    }
    public String getGateNumber() {
            return gateNumber;
        }
    public GateStatus getStatus() {
            return status;
        }
    public void setStatus(GateStatus status) {
            this.status = status;
        }

}
