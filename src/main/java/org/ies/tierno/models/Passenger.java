package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Passenger implements Comparable<Passenger>{
    private String nif;
    private Integer seatNumber;
    private List<Luggage> luggages;

    @Override
    public int compare(Passenger o1, Passenger o2) {
        int compare = o1.getNif().compareTo(o2.getNif());
        if (compare==0){
            compare = o1.getSeatNumber().compareTo(o2.getSeatNumber());
            return compare;
        }
        return compare;
    }

    @Override
    public int compareTo(Passenger passenger) {
        return 0;
    }
}
