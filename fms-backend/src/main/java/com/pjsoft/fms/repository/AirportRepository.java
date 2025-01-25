package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pjsoft.fms.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{
	
}
