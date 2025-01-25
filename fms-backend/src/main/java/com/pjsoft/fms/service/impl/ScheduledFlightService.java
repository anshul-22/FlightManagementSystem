package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.repository.ScheduledFlightRepository;
@Service
public class ScheduledFlightService {
	
	@Autowired
	private ScheduledFlightRepository scheduledFlightRepository;

	public List<ScheduledFlight> getAllScheduledFlights() {
		return scheduledFlightRepository.findAll();
	}

	public ScheduledFlight getScheduledFlightById(Long id) throws ResourceNotFoundException {
		return scheduledFlightRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("ScheduledFlight with id: "+id+" not found!"));

	}

	public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledFlight) {
		return scheduledFlightRepository.save(scheduledFlight);

	}

	public void deleteScheduledFlight(Long id) throws ResourceNotFoundException{
		if(scheduledFlightRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("ScheduledFlight with id: "+id+" not found");
		}
		scheduledFlightRepository.deleteById(id);
	}

}
