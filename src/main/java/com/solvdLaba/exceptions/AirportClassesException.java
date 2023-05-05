package com.solvdLaba.exceptions;

public abstract class AirportClassesException extends RuntimeException{
    public AirportClassesException(){
        super();}
    public AirportClassesException(String message){
        super(message);}
    public AirportClassesException(Throwable cause){
        super(cause);}
    public AirportClassesException(String message, Throwable cause){
        super(message, cause);}
}
