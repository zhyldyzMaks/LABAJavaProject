package com.solvdLaba.airport;

import com.solvdLaba.exceptions.FlightNotFoundException;
import com.solvdLaba.exceptions.InvalidAgeException;
import com.solvdLaba.exceptions.NoSeatAvailable;
import com.solvdLaba.exceptions.NoSuchTerminalException;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args){

        List<Passenger> allPassengers = new LinkedList<>();
        Airline american = new Airline("American");

        DomesticAirport dAirport1 = new DomesticAirport("O'Hare", "Chicago");
        DomesticAirport dAirport2 = new DomesticAirport("Kennedy","NY");
        System.out.println(dAirport1.equals(dAirport2));

        Runway status = Runway.OPEN;
        System.out.println("The runway status is " + status.getStatus());

        Passenger james = new Passenger("James", 35);
        Luggage luggage = new Luggage(34, "checked-in");
        james.setLuggage(luggage);
        String dateOfFlight = "2023-04-30 03:00";
        Date dNow = null;
        try {
            dNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateOfFlight);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Terminal departureTerminal = Terminal.TERMINAL_1;
        Terminal arrivalTerminal = Terminal.TERMINAL_5;
        try {
            Terminal.getTerminalInfo("Terminal 2");
        } catch (NoSuchTerminalException e) {
            System.out.println("Invalid terminal name: " + e.getInvalidTerminal());
            System.out.println(e.getMessage());
        }
        Flight ordLA = new Flight("2664", dAirport1, dAirport2, 2, dNow, "2 hours",
                departureTerminal, arrivalTerminal);
        ordLA.setFlightState(FlightState.SCHEDULED);
        american.addFlight(ordLA);
        ordLA.addPassenger(james);
        try {
            american.findFlight("GC-213");
        } catch (FlightNotFoundException e) {
            e.getFlightNumber();
            e.printStackTrace();
        }

        Ticket myTicket = null;
        try {
            myTicket = Ticket.bookTicket(ordLA, james, "regular");
        } catch (NoSeatAvailable e) {
            System.out.println("Search for new flight");
            System.out.println("Departure: " + e.getDepartureAirport().name);
            System.out.println("Arrival: " + e.getArrivalAirport().name);
            System.out.println("Date of flight: " + e.getDate());
            e.printStackTrace();
        } catch (InvalidAgeException e) {
            System.out.println("Age cannot be less than 0. Setup a proper age.");
            e.printStackTrace();
        }
        myTicket.ticketDetails();
        System.out.println();
        System.out.println(ordLA);
        james.setTSAChecked(true);

        System.out.println("===============Second ticket info=================");
        Passenger alex = new Passenger("Alex",41);
        Luggage alexLug=new Luggage(8,"carry on");
        alex.setLuggage(alexLug);
        ordLA.addPassenger(alex);


        Ticket t2 = null;
        try {
            t2 = Ticket.bookTicket(ordLA, alex, "business");
        } catch (NoSeatAvailable e) {
            System.out.println("Search for new flight");
            System.out.println("Departure: " + e.getDepartureAirport().name);
            System.out.println("Arrival: " + e.getArrivalAirport().name);
            System.out.println("Date of flight: " + e.getDate());
            e.printStackTrace();
        } catch (InvalidAgeException e) {
            System.out.println("Age cannot be less than 0. Setup a proper age.");
            e.printStackTrace();
        }
        t2.ticketDetails();
        System.out.println("==============="+alex.getName()+" flight info ================");
        System.out.println(ordLA);
        System.out.println(myTicket.equals(t2));

        try {
            Ticket thirdTicket =  Ticket.bookTicket(ordLA, james, "business");
        }catch (NoSeatAvailable e){
            System.out.println("Search for new flight");
            System.out.println("Departure: " + e.getDepartureAirport().name);
            System.out.println("Arrival: " + e.getArrivalAirport().name);
            System.out.println("Date of flight: " + e.getDate());
            e.printStackTrace();
        } catch (InvalidAgeException e) {
            System.out.println("Age cannot be less than 0. Setup a proper age.");
            e.printStackTrace();
        }


        allPassengers.add(james);
        allPassengers.add(alex);

        Boarding boarding = new Boarding();
        boarding.checkIn(james);
        boarding.checkIn(alex);
        boarding.openGate();
        boarding.boardPassengers(allPassengers);


        allPassengers.forEach(passenger -> {
            passenger.setBoardingPass(boarding);
            passenger.setTSAChecked(true);
            System.out.println(passenger.isTSAChecked());
            passenger.skipSecurityCheckLine(true);

            if (passenger.isTSAChecked()) {
                System.out.println(passenger.getName()+" can skip security line.");
            }
        });

        List<Luggage> allLuggage = new ArrayList<>();
        allLuggage.add(luggage);
        allLuggage.add(alexLug);

        List<Luggage> overweightLuggage = allLuggage.stream()
                .filter(Luggage.isOverweightFilter()::isOverweight)
                .collect(Collectors.toList());

        System.out.println(overweightLuggage);

        List<Gate> allDomesticGates = new ArrayList<>();

        Gate gate1 = new Gate(dAirport1,"A1", GateStatus.GATE_OPEN);
        Gate gate2 = new Gate(dAirport1,"C3", GateStatus.START_BOARDING);
        allDomesticGates.add(gate1);
        allDomesticGates.add(gate2);

        dAirport1.closeAllGates();
        System.out.println(allDomesticGates.get(0).getStatus());

        Field[] ordLAFields = ordLA.getClass().getDeclaredFields();
        for (Field field : ordLAFields){
            if (field.getName().equals("flightNumber")){
                field.setAccessible(true);
                try {
                    field.set(ordLA,"TK-1234");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(ordLA.getFlightNumber());

    }
}
