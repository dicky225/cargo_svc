package com.example.cargo_svc.controller;

import com.example.cargo_svc.object.dto.FlightSearchByAirportCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByFlightNumCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByRouteCriteria;
import com.example.cargo_svc.object.dto.FlightSearchResult;
import com.example.cargo_svc.service.FlightStatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class FlightControllerTest {
    @Mock
    FlightStatusService flightStatusService;

    @InjectMocks
    FlightController flightController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchByFlightNumCriteria_returnsOkAndResults() {
        FlightSearchByFlightNumCriteria criteria = new FlightSearchByFlightNumCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightStatusService.searchByFlightNumCriteria(criteria)).thenReturn(expected);

        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByFlightNumCriteria(criteria);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
        verify(flightStatusService).searchByFlightNumCriteria(criteria);
    }

    @Test
    void searchByAirportCriteria_returnsOkAndResults() {
        FlightSearchByAirportCriteria criteria = new FlightSearchByAirportCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightStatusService.searchByAirportCriteria(criteria)).thenReturn(expected);

        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByAirportCriteria(criteria);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
        verify(flightStatusService).searchByAirportCriteria(criteria);
    }

    @Test
    void searchByRouteCriteria_returnsOkAndResults() {
        FlightSearchByRouteCriteria criteria = new FlightSearchByRouteCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightStatusService.searchByRouteCriteria(criteria)).thenReturn(expected);

        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByRouteCriteria(criteria);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
        verify(flightStatusService).searchByRouteCriteria(criteria);
    }

    @Test
    void searchByFlightNumCriteria_nullCriteria_returnsOkAndEmpty() {
        when(flightStatusService.searchByFlightNumCriteria(null)).thenReturn(Collections.emptyList());
        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByFlightNumCriteria(null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
        verify(flightStatusService).searchByFlightNumCriteria(null);
    }

    @Test
    void searchByAirportCriteria_nullCriteria_returnsOkAndEmpty() {
        when(flightStatusService.searchByAirportCriteria(null)).thenReturn(Collections.emptyList());
        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByAirportCriteria(null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
        verify(flightStatusService).searchByAirportCriteria(null);
    }

    @Test
    void searchByRouteCriteria_nullCriteria_returnsOkAndEmpty() {
        when(flightStatusService.searchByRouteCriteria(null)).thenReturn(Collections.emptyList());
        ResponseEntity<List<FlightSearchResult>> response = flightController.searchByRouteCriteria(null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
        verify(flightStatusService).searchByRouteCriteria(null);
    }
}
