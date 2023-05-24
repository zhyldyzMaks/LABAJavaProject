package com.solvdLaba.airport;

public class PassengerThread extends Thread{

    private Passenger passenger;

    public PassengerThread(Passenger passenger){
        this.passenger = passenger;
    }

    public void run(){
        System.out.println("PassengerThread is running");
        System.out.println("Passenger name: " + passenger.getName());
        System.out.println("Passenger age: " + passenger.getAge());

    }

}
