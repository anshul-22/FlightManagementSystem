package com.pjsoft.fms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.dto.FlightDTO;
import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.FlightMapper;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.service.impl.FlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFlightById(@PathVariable Long id) throws ResourceNotFoundException {
        Flight flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
        //return flightService.getFlightById(id);
    }

    @PostMapping
    public Flight createFlight(@RequestBody @Valid FlightDTO flightDto) throws ResourceNotFoundException {
        return flightService.saveFlight(flightMapper.dtoToEntityMapper(flightDto));
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody @Valid Flight flight) throws ResourceNotFoundException {
    	if(flightService.getFlightById(id)==null) {
			throw new ResourceNotFoundException("Flight with Id: "+ id +" not found");
		}
        flight.setId(id);
        return flightService.saveFlight(flight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) throws ResourceNotFoundException {
        if(flightService.deleteFlight(id)) {
        	return new ResponseEntity<>( "Deleted Successfully with id: "+id,HttpStatus.OK);
        }
        return new ResponseEntity<>("Error Occured",HttpStatus.BAD_REQUEST);
    }
}