package com.solvdLaba.airport;

import com.solvdLaba.utils.MyLogger;

import java.util.Map;

public class Passenger implements Security{
    private String name;
    private int age;
    private Luggage luggage;
    private boolean isTSAChecked;

    private Map<String, Integer> passengers;

    public Luggage getLuggage() {
        return luggage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    private Boarding boardingPass;
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

    protected boolean hasValidBoardingPass(Passenger p1){
        if (p1.getBoardingPass()==null){
            return false;
        }if (!p1.getName().equals(p1.getBoardingPass().getName(p1))) {
            return false;
        }return true;
    }

    @Override
    public void skipSecurityCheckLine(boolean checked){
        if (checked){
            this.isTSAChecked = true;
        }else{
            this.isTSAChecked = false;
        }
    }
}
