package com.example.cargo_svc.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FlightSearchByRouteCriteria {
    String originAirportCode;
    String destinationAirportCode;
    LocalDate date;
}