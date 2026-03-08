package org.ies.tierno;

import org.ies.tierno.models.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Luggage> luggages = List.of(
                new Luggage(1, "Maleta1"),
                new Luggage(2, "Maleta2"));

        Map<Integer, Passenger> passengerMap = new HashMap<>();
        passengerMap.put(1, new Passenger("22425554j", 2, luggages));
        passengerMap.put(2, new Passenger("jdfhdjf2", 3, luggages));
        Map<Integer, Flight> flightMap = new HashMap<>();
        flightMap.put(1, new Flight(1, "es", "usa", LocalDate.now(), passengerMap));
        List<Customer> customers = List.of(
                new Customer("22425554j", "pepe", "FERNANDEZ"),
                new Customer("jdfhdjf2", "juan", "dsfdg")
        );
        Airline airline = new Airline("Aerolinea", flightMap, customers);

        airline.passengersFromAFlight(1).stream()
                .forEach(passengers -> System.out.println(passengers));
        System.out.println(airline.customerInFlight(1));
        System.out.println(airline.customersWithThisSurname("FERNANDEZ"));
        System.out.println(airline.findSeatNumber(1, "22425554j"));
        System.out.println(airline.flightsOfACustomer("22425554j"));
        airline.addLuggage(1, "2242554j", new Luggage(3, "Maleta Rara"));
        System.out.println(passengerMap);
    }
}
