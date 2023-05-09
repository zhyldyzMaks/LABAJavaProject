package com.solvdLaba.exceptions;

public final class InvalidBoardingPassException extends Exception {

    private String passengerName;

    public InvalidBoardingPassException(String message, String passengerName){
        super(message);
        this.passengerName = passengerName;
        System.out.println(message);
    }
    public String getPassengerName() {
        return passengerName;
    }

}
