package com.solvdLaba.airport.services;

import com.solvdLaba.airport.entities.Flight;
import com.solvdLaba.airport.entities.Passenger;
import com.solvdLaba.airport.entities.Ticket;
import com.solvdLaba.airport.utils.MyLogger;
import com.solvdLaba.customExceptions.InvalidAgeException;
import com.solvdLaba.customExceptions.NoSeatAvailable;

import java.util.Random;

public class TicketService {

    public static Ticket bookTicket(Flight flight, Passenger passenger, String preferredClass) throws NoSeatAvailable, InvalidAgeException {
        String seatNumber = String.valueOf(flight.getAvailableSeats(preferredClass));
        double ticketCost = calculateTicketCost(flight, passenger, preferredClass);
        String ticketNumber = generateTicketNumber(flight, passenger, seatNumber);
        MyLogger.warn("Checking availability for ticket");
        if (flight.availableSeats > 0) {
            flight.availableSeats--;
            return new Ticket(ticketNumber, seatNumber, ticketCost);
        } else {
            System.out.println("No available seats");
            throw new NoSeatAvailable("Seats are gone", flight);
        }
    }

    private static double calculateTicketCost(Flight flight, Passenger passenger, String preferredClass) throws InvalidAgeException {
        MyLogger.warn("Calculating ticket cost:" + flight);
        Random random = new Random();
        double originalCost = random.nextDouble(150, 500);
        if (preferredClass.equalsIgnoreCase("business")) {
            originalCost = originalCost * 1.8;
        }
        double discount = getDiscount(passenger);

        double discountedPrice = originalCost * (1 - discount);

        return discountedPrice;
    }

    static double getDiscount(Passenger passenger) throws InvalidAgeException {
        if (passenger.getAge() < 0) {
            throw new InvalidAgeException("Invalid age: " + passenger.getAge(), passenger.getAge());
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
}