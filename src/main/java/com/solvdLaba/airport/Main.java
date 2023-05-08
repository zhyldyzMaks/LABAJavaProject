package com.solvdLaba.airport;

import com.solvdLaba.exceptions.InvalidAgeException;
import com.solvdLaba.exceptions.InvalidBoardingPassException;
import com.solvdLaba.exceptions.NoSeatAvailable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws ParseException, InvalidBoardingPassException, NoSeatAvailable, InvalidAgeException {
        List<Passenger> allPassengers = new LinkedList<>();
        Airline american = new Airline("American");

        DomesticAirport dAirport1 = new DomesticAirport("O'Hare", "Chicago");
        DomesticAirport dAirport2 = new DomesticAirport("Kennedy","NY");

        Passenger james = new Passenger("James", 35);
        Luggage luggage = new Luggage(34, "carry on");
        james.setLuggage(luggage);
        String dateOfFlight = "2023-04-30 03:00";
        Date dNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateOfFlight);


        Flight ordLA = new Flight("2664", dAirport1, dAirport2, 2, dNow, "2 hours");
        american.addFlight(ordLA);
        ordLA.addPassenger(james);

        Ticket myTicket = Ticket.bookTicket(ordLA, james, "regular");
        myTicket.ticketDetails();
        System.out.println();
        System.out.println(ordLA);
        james.setTSAChecked(true);

        System.out.println("===============Second ticket info=================");
        Passenger alex = new Passenger("Alex",41);
        Luggage alexLug=new Luggage(10,"carry on");
        alex.setLuggage(alexLug);
        ordLA.addPassenger(alex);

        ordLA.setFlightState(FlightState.GATE_OPEN);

        Ticket t2 = Ticket.bookTicket(ordLA, alex, "business");
        t2.ticketDetails();
        System.out.println("==============="+alex.getName()+" flight info ================");
        System.out.println(ordLA);
        System.out.println(myTicket.equals(t2));

        try {
            Ticket thirdTicket =  Ticket.bookTicket(ordLA, james, "business");
        }catch (NoSeatAvailable e){
            System.out.println("Search for new flight");
            System.out.println("Departure: " + e.getDepartureAirport().airportName);
            System.out.println("Arrival: " + e.getArrivalAirport().airportName);
            System.out.println("Date of flight: " + e.getDate());
        }


        allPassengers.add(james);
        allPassengers.add(alex);

        Boarding boarding = new Boarding();
        boarding.checkIn(james);
        boarding.checkIn(alex);
        boarding.openGate();

        boarding.boardPassengers(allPassengers);

        for (Passenger passenger : allPassengers) {
            passenger.setBoardingPass(boarding);
            passenger.setTSAChecked(true);
            System.out.println(passenger.isTSAChecked());
            passenger.skipSecurityCheckLine(true);

        }
        System.out.println(ordLA.getPassengers());

    }
}
