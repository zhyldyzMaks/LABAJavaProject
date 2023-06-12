package com.solvdLaba.airport.entities;

import com.solvdLaba.airport.services.Security;
import com.solvdLaba.airport.utils.MyLogger;
import com.solvdLaba.customExceptions.InvalidAgeException;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Passenger implements Security {

    private String name;
    private int age;
    private boolean isTSAChecked;
    private Luggage luggage;
    private Boarding boardingPass;

    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
        MyLogger.info("Passenger getting created:  " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        this.age = age;
        if (age < 0){
            throw new InvalidAgeException("Age cannot be less than zero", age);
        }
    }

    public boolean isTSAChecked() {
        return isTSAChecked;
    }

    public void setTSAChecked(boolean TSAChecked) {
        isTSAChecked = TSAChecked;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public Boarding getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(Boarding boardingPass) {
        this.boardingPass = boardingPass;
    }

    @Override
    public void skipSecurityCheckLine(boolean checked) {
        this.isTSAChecked = checked;
    }

    @Override
    public int hashCode() {
        return (int) name.hashCode();
    }

    public void checkLuggage(Consumer<Luggage> luggageConsumer) {
        luggageConsumer.accept(luggage);
    }

    public boolean isAdultPassenger(Predicate<Passenger> agePredicate) {
        return agePredicate.test(this);
    }

    @Override
    public String toString() {
        return "PassengerEn{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}