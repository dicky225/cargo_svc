package com.example.cargo_svc.repository;

import com.example.cargo_svc.object.dto.FlightSearchByAirportCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByFlightNumCriteria;
import com.example.cargo_svc.object.dto.FlightSearchByRouteCriteria;
import com.example.cargo_svc.object.dto.FlightSearchResult;
import com.example.cargo_svc.object.entity.FlightSearchEntity;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightSearchRepository {
    @Autowired
    EntityManager em;

    public List<FlightSearchResult> searchByFlightNumCriteria(FlightSearchByFlightNumCriteria criteria) {
        List<FlightSearchResult> result;
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<FlightSearchResult> query = builder.createQuery(FlightSearchResult.class);

        Root<FlightSearchEntity> searchRoot = query.from(FlightSearchEntity.class);

        query.select(builder.construct(
                FlightSearchResult.class,
                searchRoot.get("carrierCode"),
                searchRoot.get("flightNum"),
                searchRoot.get("originAirportCode"),
                searchRoot.get("destinationAirportCode"),
                searchRoot.get("flightDate"),
                searchRoot.get("aircraftType"),
                searchRoot.get("aircraftCategory"),
                searchRoot.get("flightStatus"),
                searchRoot.get("flightCancelled"),
                searchRoot.get("departureTime"),
                searchRoot.get("arrivalTime")
        ));

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(criteria.getFlightNum())) {
            predicates.add(builder.equal(searchRoot.get("flightNum"), criteria.getFlightNum()));
        }
        if (criteria.getDate() != null) {
            predicates.add(builder.equal(searchRoot.get("flightDate"), criteria.getDate()));
        }
        if (StringUtils.isNotEmpty(criteria.getStatus())) {
            predicates.add(builder.equal(searchRoot.get("flightStatus"), criteria.getStatus()));
        }

        if (!predicates.isEmpty()) {
            query.where(builder.and(predicates.toArray(new Predicate[]{})));
        }

        result = em.createQuery(query).getResultList();
        return result;
    }

    public List<FlightSearchResult> searchByAirportCriteria(FlightSearchByAirportCriteria criteria) {
        List<FlightSearchResult> result;
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<FlightSearchResult> query = builder.createQuery(FlightSearchResult.class);

        Root<FlightSearchEntity> searchRoot = query.from(FlightSearchEntity.class);

        query.select(builder.construct(
                FlightSearchResult.class,
                searchRoot.get("carrierCode"),
                searchRoot.get("flightNum"),
                searchRoot.get("originAirportCode"),
                searchRoot.get("destinationAirportCode"),
                searchRoot.get("flightDate"),
                searchRoot.get("aircraftType"),
                searchRoot.get("aircraftCategory"),
                searchRoot.get("flightStatus"),
                searchRoot.get("flightCancelled"),
                searchRoot.get("departureTime"),
                searchRoot.get("arrivalTime")
        ));

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(criteria.getAirportCode())) {
            Predicate originMatch = builder.equal(searchRoot.get("originAirportCode"), criteria.getAirportCode());
            Predicate destinationMatch = builder.equal(searchRoot.get("destinationAirportCode"), criteria.getAirportCode());
            predicates.add(builder.or(originMatch, destinationMatch));
        }
        if (criteria.getDate() != null) {
            predicates.add(builder.equal(searchRoot.get("flightDate"), criteria.getDate()));
        }
        if (StringUtils.isNotEmpty(criteria.getStatus())) {
            predicates.add(builder.equal(searchRoot.get("flightStatus"), criteria.getStatus()));
        }

        if (!predicates.isEmpty()) {
            query.where(builder.and(predicates.toArray(new Predicate[]{})));
        }

        result = em.createQuery(query).getResultList();
        return result;
    }

    public List<FlightSearchResult> searchByRouteCriteria(FlightSearchByRouteCriteria criteria) {
        List<FlightSearchResult> result;
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<FlightSearchResult> query = builder.createQuery(FlightSearchResult.class);

        Root<FlightSearchEntity> searchRoot = query.from(FlightSearchEntity.class);

        query.select(builder.construct(
                FlightSearchResult.class,
                searchRoot.get("carrierCode"),
                searchRoot.get("flightNum"),
                searchRoot.get("originAirportCode"),
                searchRoot.get("destinationAirportCode"),
                searchRoot.get("flightDate"),
                searchRoot.get("aircraftType"),
                searchRoot.get("aircraftCategory"),
                searchRoot.get("flightStatus"),
                searchRoot.get("flightCancelled"),
                searchRoot.get("departureTime"),
                searchRoot.get("arrivalTime")
        ));

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(criteria.getOriginAirportCode())) {
            predicates.add(builder.equal(searchRoot.get("originAirportCode"), criteria.getOriginAirportCode()));
        }
        if (StringUtils.isNotEmpty(criteria.getDestinationAirportCode())) {
            predicates.add(builder.equal(searchRoot.get("destinationAirportCode"), criteria.getDestinationAirportCode()));
        }
        if (criteria.getDate() != null) {
            predicates.add(builder.equal(searchRoot.get("flightDate"), criteria.getDate()));
        }

        if (!predicates.isEmpty()) {
            query.where(builder.and(predicates.toArray(new Predicate[]{})));
        }

        result = em.createQuery(query).getResultList();
        return result;
    }
}
