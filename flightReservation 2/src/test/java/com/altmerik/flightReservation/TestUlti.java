package com.altmerik.flightReservation;

import com.altmerik.flightReservation.domain.FlightDetails;
import com.altmerik.flightReservation.domain.Flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestUlti {
    public static Flights getFlights() throws ParseException {

        FlightDetails flightDetails = new FlightDetails("1234","5678",
                new SimpleDateFormat("MM-dd-yyyy").parse("06-10-2020"),new SimpleDateFormat("MM-dd-yyyy").parse("06-10-2020"),
                "50 mins",2,1000.50);
        FlightDetails flightDetails1 = new FlightDetails("1234","5678",
                new SimpleDateFormat("MM-dd-yyyy").parse("06-10-2020"),new SimpleDateFormat("MM-dd-yyyy").parse("06-10-2020"),
                "50 mins",2,2000.50);

        List<FlightDetails> lstFlightDetails = new ArrayList<FlightDetails>();

        lstFlightDetails.add(flightDetails);
        lstFlightDetails.add(flightDetails1);

        Flights flights = new Flights(lstFlightDetails,2);
        return  flights;
    }
}
