package com.altmerik.flightReservation.service;

import com.altmerik.flightReservation.domain.Flights;

import java.text.ParseException;
import java.util.Date;

public interface IfindFlights {
    Flights getFlights(String source, String destination, Date date) throws ParseException;

}
