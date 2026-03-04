package org.ies.tierno;

import org.ies.tierno.models.Passenger;

import java.util.Comparator;

public class Comparator2 implements Comparator<Passenger> {
    @Override
    public int compare(Passenger o1, Passenger o2) {
        int compare = o1.getSeatNumber().compareTo(o2.getSeatNumber());
        return compare;
    }
}
