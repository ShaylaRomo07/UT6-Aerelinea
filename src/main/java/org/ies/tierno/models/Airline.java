package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j
@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightsByFlightNumber;
    private List<Customer> customers;

    public List<Passenger> passengersFromAFlight(int flightNumber) {
        return flightsByFlightNumber
                .get(flightNumber)
                .getPassengerBySeatNumber()
                .values()
                .stream()
                .toList();
    }

    public List<Customer> customerInFlight(int numberFlight) {
        List<String> nifs = passengersFromAFlight(numberFlight).stream()
                .map(passenger -> passenger.getNif())
                .toList();
        return customers.stream()
                .filter(customer -> nifs.contains(customer.getNif()))
                .toList();
//        List<Passenger> passengers = passengersFromAFlight(numberFlight);
//        List<Customer> customersInFlight = new ArrayList<>();
//        for (Passenger passenger : passengers) {
//            for (Customer customer : customers) {
//                if (customer.getNif().equals(passenger.getNif())) {
//                    customersInFlight.add(customer);
//                }
//            }
//        }
//        return customersInFlight;
    }

    public List<Customer> customersWithThisSurname(String surname) {
        return customers
                .stream()
                .filter(customer -> customer.getSurname().equals(surname))
                .toList();
    }

    public Integer findSeatNumber(int flightNumber, String nif) {
        if (flightsByFlightNumber.containsKey(flightNumber)) {
            List<Passenger> passengers = passengersFromAFlight(flightNumber);
            for (Passenger passenger : passengers) {
                if (passenger.getNif().equals(nif)) {
                    return passenger.getSeatNumber();
                }
            }
            return null;
        }
        return null;
    }

    public boolean addLuggage(int flightNumber, String nif, Luggage luggage) {
        if (flightsByFlightNumber.containsKey(flightNumber)) {
            List<Passenger> passengers = passengersFromAFlight(flightNumber);
                for (Passenger passenger : passengers) {
                    if (passenger.getNif().equals(nif)) {
                        List<Luggage> luggages = new ArrayList<>();
                        luggages.addAll(passenger.getLuggages());
                        luggages.add(luggage);
                        passenger.setLuggages(luggages);
                        return true;
                    }
                }
                log.error("No se encuentra un pasajero con ese nif");
        } else {
            log.error("No se encuentra el vuelo con ese numero de vuelo");
        }
        return false;
    }

    public List<Flight> flightsOfACustomer(String nif) {
        List<Flight> flights = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                for (Flight flight : flightsByFlightNumber.values()) {
                    for (Passenger passenger : flight.getPassengerBySeatNumber().values()) {
                        if (passenger.getNif().equals(nif)) {
                            flights.add(flight);
                        }
                    }
                }
            }
        }
        return flights;
    }
}
