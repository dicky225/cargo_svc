package com.example.cargo_svc.service;

import com.example.cargo_svc.object.dto.FlightSearchByAirportCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByFlightNumCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByRouteCriteria;
import com.example.cargo_svc.object.dto.FlightSearchResult;
import com.example.cargo_svc.repository.FlightSearchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class FlightStatusServiceTest {
    @Mock
    FlightSearchRepository flightSearchRepository;

    @InjectMocks
    FlightStatusService flightStatusService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchByFlightNumCriteria_returnsResults() {
        FlightSearchByFlightNumCriteria criteria = new FlightSearchByFlightNumCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightSearchRepository.searchByFlightNumCriteria(criteria)).thenReturn(expected);

        List<FlightSearchResult> result = flightStatusService.searchByFlightNumCriteria(criteria);
        assertThat(result).isEqualTo(expected);
        verify(flightSearchRepository).searchByFlightNumCriteria(criteria);
    }

    @Test
    void searchByAirportCriteria_returnsResults() {
        FlightSearchByAirportCriteria criteria = new FlightSearchByAirportCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightSearchRepository.searchByAirportCriteria(criteria)).thenReturn(expected);

        List<FlightSearchResult> result = flightStatusService.searchByAirportCriteria(criteria);
        assertThat(result).isEqualTo(expected);
        verify(flightSearchRepository).searchByAirportCriteria(criteria);
    }

    @Test
    void searchByRouteCriteria_returnsResults() {
        FlightSearchByRouteCriteria criteria = new FlightSearchByRouteCriteria();
        List<FlightSearchResult> expected = Collections.singletonList(new FlightSearchResult());
        when(flightSearchRepository.searchByRouteCriteria(criteria)).thenReturn(expected);

        List<FlightSearchResult> result = flightStatusService.searchByRouteCriteria(criteria);
        assertThat(result).isEqualTo(expected);
        verify(flightSearchRepository).searchByRouteCriteria(criteria);
    }

    @Test
    void searchByFlightNumCriteria_nullCriteria_returnsNullOrEmpty() {
        when(flightSearchRepository.searchByFlightNumCriteria(null)).thenReturn(Collections.emptyList());
        List<FlightSearchResult> result = flightStatusService.searchByFlightNumCriteria(null);
        assertThat(result).isEmpty();
        verify(flightSearchRepository).searchByFlightNumCriteria(null);
    }

    @Test
    void searchByAirportCriteria_nullCriteria_returnsNullOrEmpty() {
        when(flightSearchRepository.searchByAirportCriteria(null)).thenReturn(Collections.emptyList());
        List<FlightSearchResult> result = flightStatusService.searchByAirportCriteria(null);
        assertThat(result).isEmpty();
        verify(flightSearchRepository).searchByAirportCriteria(null);
    }

    @Test
    void searchByRouteCriteria_nullCriteria_returnsNullOrEmpty() {
        when(flightSearchRepository.searchByRouteCriteria(null)).thenReturn(Collections.emptyList());
        List<FlightSearchResult> result = flightStatusService.searchByRouteCriteria(null);
        assertThat(result).isEmpty();
        verify(flightSearchRepository).searchByRouteCriteria(null);
    }
}
