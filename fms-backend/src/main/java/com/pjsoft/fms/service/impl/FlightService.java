package com.pjsoft.fms.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.repository.FlightRepository;

@Service
public class FlightService{
    @Autowired
    private FlightRepository flightRepository;
    private static final Logger logger = LoggerFactory.getLogger(PassengerService.class);

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) throws ResourceNotFoundException {
        logger.debug("inside getFlightById");
        return flightRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }

    public Flight saveFlight(Flight flight) throws ResourceNotFoundException {
        return flightRepository.save(flight);
    }

    public boolean deleteFlight(Long id) throws ResourceNotFoundException {
        if (flightRepository.findById(id).isPresent()) {
            flightRepository.deleteById(id);
            return true;
        }
        throw new ResourceNotFoundException("Flight with Id: " + id + " not found");
    }

}