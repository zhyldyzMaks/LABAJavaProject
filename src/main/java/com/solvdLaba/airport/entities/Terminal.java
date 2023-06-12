package com.solvdLaba.airport.entities;

import com.solvdLaba.customExceptions.NoSuchTerminalException;

public enum Terminal {

    TERMINAL_1("Terminal 1"),
    TERMINAL_2("Terminal 2"),
    TERMINAL_3("Terminal 3"),
    TERMINAL_4("Terminal 4"),
    TERMINAL_5("Terminal 5");

    private String name;

    Terminal(String name){
        this.name=name;
    }
    public static Terminal getTerminalInfo(String name) throws NoSuchTerminalException {
        for (Terminal terminal : Terminal.values()) {
            if (terminal.getName().equalsIgnoreCase(name)) {
                return terminal;
            }
        }
        throw new NoSuchTerminalException("Terminal not found: " + name, name);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Terminal - "  + name;
    }
}