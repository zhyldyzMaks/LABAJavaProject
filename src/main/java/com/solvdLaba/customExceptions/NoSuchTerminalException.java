package com.solvdLaba.customExceptions;

public class NoSuchTerminalException extends Exception{

    private String invalidTerminal;

    public NoSuchTerminalException(String message, String invalidTerminal){
        super(message);
        this.invalidTerminal = invalidTerminal;
    }

    public String getInvalidTerminal(){
        return invalidTerminal;
    }
}