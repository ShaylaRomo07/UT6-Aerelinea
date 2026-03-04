package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Passenger{
    private String nif;
    private Integer seatNumber;
    private List<Luggage> luggages;
}
