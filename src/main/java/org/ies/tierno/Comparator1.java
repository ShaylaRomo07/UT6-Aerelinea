package org.ies.tierno;

import org.ies.tierno.models.Passenger;

import java.util.Comparator;

public class Comparator1 implements Comparator<Passenger> {
    @Override
    public int compare(Passenger o1, Passenger o2) {
        int compare = o1.getNif().compareTo(o2.getNif());
        return compare;
    }
}
