package com.example.cargo_svc.repository;

import com.example.cargo_svc.object.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
}
