package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class Passenger implements Comparable<Passenger> {
    private String nif;
    private Integer seatNumber;
    private List<Luggage> luggages;

    @Override
    public int compareTo(Passenger passenger) {
        int compare = nif.compareTo(passenger.getNif());
        if (compare == 0) {
            compare = Integer.compare(this.seatNumber, passenger.getSeatNumber());
        }
        return compare;
    }
}
