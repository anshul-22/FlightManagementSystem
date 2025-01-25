package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.repository.ScheduleRepository;
@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	public Schedule getScheduleById(Long id) throws ResourceNotFoundException {
		return scheduleRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Schedule with id: "+id+" not found!"));

	}

	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);

	}

	public void deleteSchedule(Long id) throws ResourceNotFoundException{
		if(scheduleRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Schedule with id: "+id+" not found");
		}
		scheduleRepository.deleteById(id);
	}

}
