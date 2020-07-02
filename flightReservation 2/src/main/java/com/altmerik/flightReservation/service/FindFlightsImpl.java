package com.altmerik.flightReservation.service;

import com.altmerik.flightReservation.domain.FlightDetails;
import com.altmerik.flightReservation.domain.Flights;
import com.altmerik.flightReservation.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindFlightsImpl implements IfindFlights {
    @Autowired
    private RestTemplate myRestTemplate;

    @Value("${myrest.url}")
    private String restUrl;

    @Override
    public Flights getFlights(String source, String destination, Date date) throws ParseException {

        Flights flight = myRestTemplate.getForObject(restUrl, Flights.class);

        Flights sortedData= sortFlightDetails(flight);


        return sortedData;
    }

    public Flights sortFlightDetails(Flights flights){

        if(flights.getTotalNoOfResults() == 0){
            ExceptionUtil.handleException();
        }

        List<FlightDetails> sortedFlights = flights.getFlightDetails().stream()
                .sorted(Comparator.comparing(FlightDetails::getPrice))
                .collect(Collectors.toList());

        return new Flights().builder()
                .flightDetails(sortedFlights)
                .totalNoOfResults(flights.getTotalNoOfResults())
                .build();

    }
}
