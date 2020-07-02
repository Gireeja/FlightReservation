package com.altmerik.flightReservation.controller;

import com.altmerik.flightReservation.TestUlti;
import com.altmerik.flightReservation.domain.Flights;
import com.altmerik.flightReservation.exception.BusinessException;
import com.altmerik.flightReservation.exception.ErrorCode;
import com.altmerik.flightReservation.service.IfindFlights;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.util.ArrayList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class FlightsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    IfindFlights ifindFlights;

    FlightsController flightsController = new FlightsController(ifindFlights);

    @Test
    public void testSuccess() throws Exception {
        Flights flights = TestUlti.getFlights();

        when(ifindFlights.getFlights(anyString(),anyString(),any()))
                .thenReturn(flights);

       this.mockMvc
               .perform(get("/searchFlights?source=chennai&destination=kerala&departDate=07-12-2020"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[*]", hasSize(2)));

    }


    @Test
    public void testException() throws Exception {


        when(ifindFlights.getFlights(anyString(),anyString(),any()))
                .thenThrow(new BusinessException(ErrorCode.EMPTY_RECORD_EXECPTION,"Empty Response"));

        this.mockMvc
                .perform(get("/searchFlights?source=chennai&destination=kerala&departDate=07-12-2020"))
                .andExpect(status().is5xxServerError());


    }


}
