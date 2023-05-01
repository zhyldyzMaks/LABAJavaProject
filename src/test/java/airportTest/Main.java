package airportTest;

import com.solvdLaba.airport.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException, DiscountCalculationException {
        DomesticAirport dAirport1 = new DomesticAirport("O'Hare", "Chicago");
        DomesticAirport dAirport2 = new DomesticAirport("Kennedy","NY");

//        Map<String,Integer> allCurrentPassengers=  new LinkedHashMap<>();
//
//        allCurrentPassengers.put("james", 23);
//        allCurrentPassengers.put("adam", 22);
//
//        Map<String, Integer> passengerMap = Passenger.createPassengerMap(allCurrentPassengers);
//        System.out.println(passengerMap);

        Passenger james = new Passenger("James", 35);
        Luggage luggage = new Luggage(34, "carry on");
        james.setLuggage(luggage);
        String oldstring = "2023-04-30 03:00";
        Date dNow = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(oldstring);

        System.out.println(dNow);
        Flight ordLA = new Flight("2664", dAirport1, dAirport2, 2, dNow, "2 hours");
        Ticket myTicket = Ticket.bookTicket(ordLA, james, "regular");

        myTicket.ticketDetails();
        System.out.println();
        System.out.println(ordLA);
        james.setTSAChecked(true);

        Ticket t2 = Ticket.bookTicket(ordLA, james, "business");

        t2.ticketDetails();
        System.out.println();
        System.out.println(ordLA);
        System.out.println(myTicket.equals(t2));

        try {
            Ticket thirdTicket =  Ticket.bookTicket(ordLA, james, "business");
        }catch (NoSeatAvailable e){
            System.out.println("search for other flights");
        }


    }
}
