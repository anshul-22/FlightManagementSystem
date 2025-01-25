package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
