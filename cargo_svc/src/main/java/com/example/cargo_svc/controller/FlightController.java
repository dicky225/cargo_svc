package com.example.cargo_svc.controller;

import com.example.cargo_svc.object.dto.FlightSearchByAirportCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByFlightNumCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByRouteCriteria;
import com.example.cargo_svc.object.dto.FlightSearchResult;
import com.example.cargo_svc.service.FlightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightStatusService flightStatusService;


    @PostMapping("/v1/flight-statuses/search-by-flight-num")
    public ResponseEntity<List<FlightSearchResult>> searchByFlightNumCriteria(@RequestBody FlightSearchByFlightNumCriteria criteria) {
        List<FlightSearchResult> results = flightStatusService.searchByFlightNumCriteria(criteria);
        return new ResponseEntity<>(results != null ? results : List.of(), HttpStatus.OK);
    }

    @PostMapping("/v1/flight-statuses/search-by-airport")
    public ResponseEntity<List<FlightSearchResult>> searchByAirportCriteria(@RequestBody FlightSearchByAirportCriteria criteria) {
        List<FlightSearchResult> results = flightStatusService.searchByAirportCriteria(criteria);
        return new ResponseEntity<>(results != null ? results : List.of(), HttpStatus.OK);
    }

    @PostMapping("/v1/flight-statuses/search-by-route")
    public ResponseEntity<List<FlightSearchResult>> searchByRouteCriteria(@RequestBody FlightSearchByRouteCriteria criteria) {
        List<FlightSearchResult> results = flightStatusService.searchByRouteCriteria(criteria);
        return new ResponseEntity<>(results != null ? results : List.of(), HttpStatus.OK);
    }

}
