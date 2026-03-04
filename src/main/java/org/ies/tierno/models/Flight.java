package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private Map<Integer, Passenger> passengerBySeatNumber;
}
