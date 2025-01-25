package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {

}