package com.solvdLaba.airport;

import com.solvdLaba.exceptions.InvalidAgeException;
import com.solvdLaba.utils.MyLogger;

public class Passenger implements Security{
    private String name;
    private int age;
    private Luggage luggage;
    private boolean isTSAChecked;
    protected Boarding boardingPass;

    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
        MyLogger.info("Passenger getting created:  " + name);
    }
    public boolean isTSAChecked() {
        return isTSAChecked;
    }
    @Override
    public void skipSecurityCheckLine(boolean checked){
        if (checked){
            this.isTSAChecked = true;
        }else{
            this.isTSAChecked = false;
        }
        this.isTSAChecked = checked;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public Luggage getLuggage() {
        return luggage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) throws InvalidAgeException {
        this.age = age;
        if (age < 0){
            throw new InvalidAgeException("Age cannot be less than zero", age);
        }
    }
    public Boarding getBoardingPass() {
        return boardingPass;
    }
    public void setBoardingPass(Boarding boardingPass) {
        this.boardingPass = boardingPass;
    }
    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }
    public void setTSAChecked(boolean TSAChecked) {
        isTSAChecked = TSAChecked;
    }
    @Override
    public int hashCode() {
        return (int) name.hashCode();
    }





}
