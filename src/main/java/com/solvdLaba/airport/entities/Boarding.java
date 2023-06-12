package com.solvdLaba.airport.entities;

import java.util.Random;

public class Boarding {

    private int boardingNumber;

    public Boarding() {
        boardingNumber = new Random().nextInt(10000);
    }

    public int getBoardingNumber() {
        return boardingNumber;
    }

    public void setBoardingNumber(int boardingNumber) {
        this.boardingNumber = boardingNumber;
    }
}