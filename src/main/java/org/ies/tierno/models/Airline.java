package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightsByFlightNumber;
    private List<Customer> customers;

    public List<Passenger> passengersFromAFlight(int flightNumber) {
        return flightsByFlightNumber.get(flightNumber).getPassengerBySeatNumber().values()
                .stream()
                .collect(Collectors.toList());
    }

    public
}
