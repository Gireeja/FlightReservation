package com.altmerik.flightReservation.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class FlightDetails {
    private String flightNumber;
    private String airlineNumebr;
    private Date arrivalDate;
    private Date depatureDate;
    private String duration;
    private int noOfStops;
    private double price;

}


