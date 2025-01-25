package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.ScheduledFlight;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {

}
