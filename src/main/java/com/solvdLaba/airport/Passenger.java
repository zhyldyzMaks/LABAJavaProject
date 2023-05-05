package com.solvdLaba.airport;

import com.solvdLaba.exceptions.InvalidAgeException;
import com.solvdLaba.exceptions.InvalidBoardingPassException;

public class Passenger implements Security{
    private String name;
    private int age;
    private Luggage luggage;
    private boolean isTSAChecked;
    private Boarding boardingPass;

    public Luggage getLuggage() {
        return luggage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws InvalidAgeException {
        this.age = age;
        if (age < 0){
            throw new InvalidAgeException("Age cannot be less than zero", new IllegalArgumentException() {
            });
        }

    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }


    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
      //  MyLogger.info("Passenger getting created:  " + name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return (int)  name.hashCode();
    }
    public Boarding getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(Boarding boardingPass) {
        this.boardingPass = boardingPass;
    }

    public void setTSAChecked(boolean TSAChecked) {
        isTSAChecked = TSAChecked;
    }

    public boolean isTSAChecked() {
        return isTSAChecked;
    }

protected boolean hasValidBoardingPass(Passenger p1) throws InvalidBoardingPassException {
    if (p1.getBoardingPass() == null) {
        throw new InvalidBoardingPassException("Boarding pass is missing");
    }
    if (!p1.getName().equals(p1.getBoardingPass().getName(p1))) {
        throw new InvalidBoardingPassException("Boarding pass name does not match passenger name");
    }
    return true;
}
    @Override
    public void skipSecurityCheckLine(boolean checked){
        if (checked){
            this.isTSAChecked = true;
        }else{
            this.isTSAChecked = false;
        }
    }

    //    protected boolean hasValidBoardingPass(Passenger p1){
//        if (p1.getBoardingPass()==null){
//            return false;
//        }if (!p1.getName().equals(p1.getBoardingPass().getName(p1))) {
//            return false;
//        }return true;
//    }
}
