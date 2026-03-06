package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        List<Passenger> passengers = passengersFromAFlight(flightNumber);
        Optional<Integer> seatNumberOptional = passengers.stream()
                .filter(passenger -> passenger.getNif().equals(nif))
                .map(passenger -> passenger.getSeatNumber())
                .findFirst();
        Integer seatNumber = seatNumberOptional.get();
        if (seatNumber != null) {
            return seatNumber;
        }
        return null;
    }
}
