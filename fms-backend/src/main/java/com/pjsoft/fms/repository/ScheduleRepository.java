package com.pjsoft.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjsoft.fms.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
