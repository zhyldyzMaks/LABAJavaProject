package com.solvdLaba.airport;

public class TicketCalculationException extends RuntimeException{
    public TicketCalculationException(String mssg){
        System.out.println(mssg);
    }
}

