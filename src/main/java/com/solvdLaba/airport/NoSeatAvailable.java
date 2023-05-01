package com.solvdLaba.airport;

public class NoSeatAvailable extends RuntimeException{
    public NoSeatAvailable(String message){
        System.out.println(message);
    }
}
