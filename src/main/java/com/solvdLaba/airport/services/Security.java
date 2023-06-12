package com.solvdLaba.airport.services;

public interface Security {

    boolean isTSAPreChecked = false;
    void skipSecurityCheckLine(boolean isTSAPreChecked);
}