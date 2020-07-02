package com.altmerik.flightReservation.controller;

import com.altmerik.flightReservation.domain.Flights;
import com.altmerik.flightReservation.service.IfindFlights;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

    @RestController
    @RequiredArgsConstructor(onConstructor = @__(@Autowired))
    public class FlightsController {

        private final IfindFlights ifindFlights;

        @GetMapping("/searchFlights")
        public ResponseEntity<Flights> findFLights(@RequestParam("source") String source, @RequestParam("destination") String destination,
                                                   @RequestParam("departDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departDate) throws ParseException {


            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ifindFlights.getFlights(source,destination,
                            departDate));


        }

    }

