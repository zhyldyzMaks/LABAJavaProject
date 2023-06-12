package com.solvdLaba.customExceptions;

public final class InvalidAgeException extends Exception {

    private int age;
    public InvalidAgeException(String message, int age){

        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getErrorMessage() {
        return getMessage() + " Age: " + age;
    }
}