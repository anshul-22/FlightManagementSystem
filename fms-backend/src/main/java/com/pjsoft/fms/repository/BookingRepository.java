package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
