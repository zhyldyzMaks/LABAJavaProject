package com.solvdLaba.airport;

import com.solvdLaba.utils.MyLogger;

import java.util.Random;

public class Ticket {
    private String ticketNumber;
    private Flight flight;
    private Passenger passenger;
    private String seatNumber;
    private String ticketClass;
    private double ticketCost;


    public Ticket(String tNumber, Flight flight, Passenger passenger, String seatNumber, String ticketClass, double ticketCost) {
        ticketNumber = tNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.ticketClass = ticketClass;
        this.ticketCost = ticketCost;
    }

    public String getNumber() {
        return ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public double getTicketCost() {
        return ticketCost;
    }
    public void ticketDetails() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Class: " + ticketClass);
        System.out.println("Ticket Cost: " + ticketCost);
    }

    public static Ticket bookTicket(Flight flight, Passenger passenger, String preferredClass) throws DiscountCalculationException {
        String seatNumber = String.valueOf(flight.getAvailableSeats(preferredClass));
        double ticketCost = calculateTicketCost(flight, passenger, preferredClass);
        String ticketNumber = generateTicketNumber(flight, passenger, seatNumber);

//        MyLogger.warn("Checking availability for ticket");
        if (flight.availableSeats > 0){
            flight.availableSeats--;
            return new Ticket(ticketNumber, flight, passenger, seatNumber, preferredClass, ticketCost);
        }else{
            System.out.println("No available seats");
            throw new NoSeatAvailable("Seats are gone");
        }
    }
    private static double calculateTicketCost(Flight flight, Passenger passenger, String preferredClass) throws DiscountCalculationException {
//        MyLogger.warn("Calculating ticket cost:" + flight);
        Random random = new Random();

        double originalCost = random.nextDouble(150, 500);
        if (preferredClass.equalsIgnoreCase("business")) {
            originalCost = originalCost * 1.8;
        }
        double discount = getDiscount(passenger);
        if(discount < 0 || discount > 1) {
            throw new TicketCalculationException("Invalid discount value");
        }
        double discountedPrice = originalCost * (1 - discount);

        if(discountedPrice <= 0) {
            throw new TicketCalculationException("Discounted price cannot be zero or negative");
        }
        return discountedPrice;
    }

    private static double getDiscount(Passenger passenger) throws DiscountCalculationException {
        if (passenger.getAge() < 0) {
            throw new DiscountCalculationException("Invalid age: " + passenger.getAge());
        }
        if (passenger.getAge() < 12) {
            return 0.2;
        } else {
            return 0.0;
        }
    }

    private static String generateTicketNumber(Flight flight, Passenger passenger, String seatNumber) {
        String flightNumber = flight.getFlightNumber();
        String passengerName = passenger.getName();
        String ticketNumber = flightNumber + "-" + seatNumber + "-" + passengerName;

        return ticketNumber;
    }


    // AgeRestrictionExc (throw)
    @Override
    public boolean equals(Object ticket){
        if (this.toString() == ticket.toString()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return this.ticketNumber;
    }




}
