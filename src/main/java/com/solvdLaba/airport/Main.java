package com.solvdLaba.airport;

import com.solvdLaba.airport.entities.*;
import com.solvdLaba.airport.entities.Boarding;
import com.solvdLaba.airport.services.*;
import com.solvdLaba.customExceptions.FlightNotFoundException;
import com.solvdLaba.customExceptions.InvalidAgeException;
import com.solvdLaba.customExceptions.NoSeatAvailable;
import com.solvdLaba.customExceptions.NoSuchTerminalException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.solvdLaba.airport.services.GateService.generateGateNumber;

public class Main {


    public static void main(String[] args){

        List<Passenger> allPassengers = new LinkedList<>();
        Airline american = new Airline("American");

        DomesticAirport domesticAirport1 = new DomesticAirport("O'Hare", "Chicago");
        DomesticAirport domesticAirport2 = new DomesticAirport("Kennedy","NY");
        System.out.println(domesticAirport1.equals(domesticAirport2));

        Runway status = Runway.OPEN;
        System.out.println("The runway status is " + status.getStatus());

        Passenger james = new Passenger("James White", 35);
        Luggage luggage = new Luggage(34, "checked-in");
        james.setLuggage(luggage);
        String dateOfFlight = "2023-04-30 03:00";
        Date dNow = null;
        try {
            dNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateOfFlight);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean isAdult = james.isAdultPassenger(p -> p.getAge() >= 18);
        System.out.println("Is adult passenger: " + isAdult);

        james.checkLuggage(l -> System.out.println("Checking luggage with weight: " + l.getWeight() + " kg"));

        Terminal departureTerminal = Terminal.TERMINAL_1;
        Terminal arrivalTerminal = Terminal.TERMINAL_5;
        try {
            Terminal.getTerminalInfo("Terminal 2");
        } catch (NoSuchTerminalException e) {
            System.out.println("Invalid terminal name: " + e.getInvalidTerminal());
            System.out.println(e.getMessage());
        }
        Flight ordLA = new Flight("2664", domesticAirport1, domesticAirport2, 2, dNow, "2 hours",
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

        Ticket ticket1 = null;

        try {
            ticket1 = TicketService.bookTicket(ordLA, james, "Regular");
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
        ticket1.ticketDetails();
        System.out.println();
        System.out.println(ordLA);
        james.setTSAChecked(true);

        System.out.println("===============Second ticket info=================");
        Passenger alex = new Passenger("Alex Doe",41);
        Luggage alexLug=new Luggage(8,"carry on");
        alex.setLuggage(alexLug);
        ordLA.addPassenger(alex);


        Ticket ticket2 = null;
        try {
            ticket2 = TicketService.bookTicket(ordLA, alex, "Business");
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
        ticket2.ticketDetails();
        System.out.println("==============="+alex.getName()+" flight info ================");
        System.out.println(ordLA);
        System.out.println(ticket1.equals(ticket2));

        try {
            Ticket thirdTicket =  TicketService.bookTicket(ordLA, james, "Business");
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

        BoardingService boardingService = new BoardingService();
        com.solvdLaba.airport.entities.Boarding boarding = new Boarding();

        boardingService.checkIn(james);
        boardingService.checkIn(alex);
        boardingService.openGate();
        boardingService.boardPassengers(allPassengers);

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

        List<GateService> allDomesticGates = new ArrayList<>();

        String gateNumber = generateGateNumber();
        String gateNumber2 = generateGateNumber();
        String gateNumber3 = generateGateNumber();

        GateService gate1 = new GateService(domesticAirport1, gateNumber, GateStatus.OPEN);
        GateService gate2 = new GateService(domesticAirport1,gateNumber2, GateStatus.BOARDING);
        GateService gate3 = new GateService(domesticAirport1,gateNumber3,GateStatus.CLOSED);
        domesticAirport1.addGate(gate1);
        domesticAirport1.addGate(gate2);
        domesticAirport1.addGate(gate3);
        allDomesticGates.add(gate1);
        allDomesticGates.add(gate2);
        allDomesticGates.add(gate3);
        System.out.println("________________________________________________");
        System.out.println("Gate Number: " + gate1.getGateNumber());
        System.out.println("Status: " + gate1.getStatus());

        System.out.println("Gate Number: " + gate2.getGateNumber());
        System.out.println("Status: " + gate2.getStatus());

        List<String> gateNumbers = domesticAirport1.getGateNumbers(g -> g.getGateNumber());
        System.out.println("Gate Numbers: " + gateNumbers);

        List<GateService> closedGates = domesticAirport1.getGatesMatching(g -> g.getStatus() == GateStatus.CLOSED);
        System.out.println("Closed Gates: " + closedGates);

        domesticAirport1.closeAllGates();
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
        System.out.println("________________________________________________");

        Stream<Ticket> ticketStream = ticket1.stream();
        ticketStream.filter(ticket -> ticket.getTicketCost() > 100.0)
                .map(Ticket::getSeatNumber)
                .forEach(System.out::println);

        List<Ticket> ticketList = List.of(ticket1, ticket2);
        ticketList.stream()
                .filter(ticket -> ticket.getTicketClass().equals("Business"))
                .map(Ticket::getPassenger)
                .forEach(passenger -> System.out.println(passenger.getName()));
        System.out.println("________________________________________________");

        FlightService flightService = new FlightService();

        Stream<Passenger> passengerStream = flightService.getPassengerStream(ordLA);
        flightService.printPassengerNames(ordLA);

        long adultPassengerCount = flightService.countAdultPassengers(ordLA);
        System.out.println("Number of adult passengers: " + adultPassengerCount);

        Stream<Passenger> passengersWithLuggageStream = flightService.getPassengersWithLuggage(ordLA);
        passengersWithLuggageStream.forEach(passenger -> System.out.println(passenger.getName() + " - " + passenger.getLuggage()));

        String passengerName = "Alex Doe";
        boolean hasPassenger = flightService.hasPassenger(ordLA, passengerName);
        System.out.println("Has passenger " + passengerName + ": " + hasPassenger);

        boolean allPassengersCheckedIn = flightService.allPassengersCheckedIn(ordLA);
        System.out.println("All passengers checked in: " + allPassengersCheckedIn);

        Runnable runnable = new FlightThread(ordLA);
        Thread flightThread = new Thread(runnable);
        flightThread.start();

        Thread passengerThread = new PassengerThread(james);
        passengerThread.start();
    }
}