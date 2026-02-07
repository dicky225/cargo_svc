package com.example.cargo_svc.object.dto;


import com.example.cargo_svc.common.enums.AircraftCategoryEnum;
import com.example.cargo_svc.common.enums.FlightStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchResult {
    String carrierCode;
    String flightNum;
    String originAirportCode;
    String destinationAirportCode;
    LocalDate flightDate;
    String aircraftType;
    AircraftCategoryEnum aircraftCategory;
    FlightStatusEnum flightStatus;
    Boolean flightCancelled;
    String departureTime;
    String arrivalTime;
}
