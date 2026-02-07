package com.example.cargo_svc.object.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight",
uniqueConstraints = {
        @UniqueConstraint(name = "unique_flight",
                columnNames = {"carrier_code", "flight_no", "flight_date", "origin", "destination"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carrier_code", nullable = false, length = 10)
    private String carrierCode;

    @Column(name = "flight_no", nullable = false, length = 10)
    private String flightNo;

    @Column(name = "origin", nullable = false, length = 10)
    private String origin;

    @Column(name = "destination", nullable = false, length = 10)
    private String destination;

    @Column(name = "flight_date", nullable = false)
    private LocalDate flightDate;

    @Column(name = "aircraft_type", length = 10)
    private String aircraftType;

    @Column(name = "aircraft_catg", length = 50)
    private String aircraftCatg;

    @Column(name = "flight_status", length = 50)
    private String flightStatus;

    @Column(name = "departure_time", length = 10)
    private String departureTime;

    @Column(name = "arrival_time", length = 10)
    private String arrivalTime;

    @Column(name = "flight_cancelled")
    private Boolean flightCancelled;

    @Column(name = "std", length = 50)
    private String std;

    @Column(name = "etd", length = 50)
    private String etd;

    @Column(name = "atd", length = 50)
    private String atd;

    @Column(name = "sta", length = 50)
    private String sta;

    @Column(name = "eta", length = 50)
    private String eta;

    @Column(name = "ata", length = 50)
    private String ata;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
