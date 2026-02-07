package com.example.cargo_svc.object.entity;

import com.example.cargo_svc.common.enums.AircraftCategoryEnum;
import com.example.cargo_svc.common.enums.FlightStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "flight")
public class FlightSearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carrier_code", nullable = false, length = 10)
    private String carrierCode;

    @Column(name = "flight_no", nullable = false, length = 10)
    private String flightNum;

    @Column(name = "origin", nullable = false, length = 10)
    private String originAirportCode;

    @Column(name = "destination", nullable = false, length = 10)
    private String destinationAirportCode;

    @Column(name = "flight_date", nullable = false)
    private LocalDate flightDate;

    @Column(name = "aircraft_type", length = 10)
    private String aircraftType;

    @Column(name = "aircraft_catg", length = 50)
    private AircraftCategoryEnum aircraftCategory;

    @Column(name = "flight_status", length = 50)
    private FlightStatusEnum flightStatus;

    @Column(name = "flight_cancelled")
    private Boolean flightCancelled;

    @Column(name = "departure_time", length = 10)
    private String departureTime;

    @Column(name = "arrival_time", length = 10)
    private String arrivalTime;
}
