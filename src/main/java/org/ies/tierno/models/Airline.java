package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

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
        return flightsByFlightNumber.get(flightNumber).getPassengerBySeatNumber().values().stream().toList();
    }

    public List<Customer> customerInFlight(int numberFlight) {
        List<String> passengersNifs = passengersFromAFlight(numberFlight).stream()
                .map(passenger -> passenger.getNif())
                .toList();
        return customers.stream().filter(customer -> passengersNifs.contains(customer))
                .toList();

    }

    public List<Customer> customersWithThisSurname(String surname) {
        return customers.stream()
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

    public void addLuggage(int flightNumber, String nif, Luggage luggage) {
        if (flightsByFlightNumber.containsKey(flightNumber)) {
            List<Passenger> passengers = passengersFromAFlight(flightNumber);
            for (Passenger passenger : passengers) {
                if (passenger.getNif().equals(nif)) {
                    passenger.getLuggages().add(luggage);
                } else {
                    log.error("No se encuentra el pasajero con ese nif");
                }
            }
        } else {
            log.error("No se encuentra el vuelo con ese numero de vuelo");
        }
    }

}
