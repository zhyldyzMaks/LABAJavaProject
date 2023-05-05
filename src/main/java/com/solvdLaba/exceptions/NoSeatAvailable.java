package com.solvdLaba.exceptions;

public final class NoSeatAvailable extends AirportClassesException {
    public NoSeatAvailable(String message){
        System.out.println(message);
    }
}
