package com.example.cargo_svc.service;

import com.example.cargo_svc.object.dto.FlightSearchByAirportCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByFlightNumCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByRouteCriteria;
import com.example.cargo_svc.object.dto.FlightSearchResult;
import com.example.cargo_svc.repository.FlightSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightStatusService {
    @Autowired
    FlightSearchRepository flightSearchRepository;

    public List<FlightSearchResult> searchByFlightNumCriteria(FlightSearchByFlightNumCriteria criteria) {
        return flightSearchRepository.searchByFlightNumCriteria(criteria);
    }
    public List<FlightSearchResult> searchByAirportCriteria(FlightSearchByAirportCriteria criteria) {
        return flightSearchRepository.searchByAirportCriteria(criteria);
    }
    public List<FlightSearchResult> searchByRouteCriteria(FlightSearchByRouteCriteria criteria) {
        return flightSearchRepository.searchByRouteCriteria(criteria);
    }
}
