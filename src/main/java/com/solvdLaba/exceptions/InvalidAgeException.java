package com.solvdLaba.exceptions;

public final class InvalidAgeException extends AirportClassesException{
    public InvalidAgeException(String message, Throwable cause){
        super(message, cause);
    }
}
