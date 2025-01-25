package com.pjsoft.fms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.dto.AirportDTO;
import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.AirportMapper;
import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.service.AirportService;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:3000")	
@RestController
@RequestMapping("/api/airports")
public class AirportController {

	@Value("${custom.variable}")
	private String variable;
	
	@Value("${java.version}")
	private String javaVersion;
	
	@Autowired
	private AirportService airportService;

	@Autowired
	private AirportMapper airportMapper;

	/* Test - Print Variable from applicaiton.properties */
	@GetMapping("/variable")
	public String getVariable() {
		return variable;
	}
	
	/* Test - Print Java Version from pom.xml */
	@GetMapping("/property")
	public String getJavaVersion() {
		return javaVersion;
	}
	
	@GetMapping
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getFlightById(@PathVariable Long id) throws ResourceNotFoundException {
		Airport airport = airportService.getAirportById(id);
		return ResponseEntity.ok(airport);
		// return flightService.getFlightById(id);
	}

	@PostMapping
	public Airport createFlight(@RequestBody @Valid AirportDTO airportDto) throws ResourceNotFoundException {
		return airportService.saveAirport(airportMapper.dtoToEntityMapper(airportDto));
	}

	@PutMapping("/{id}")
	public Airport updateFlight(@PathVariable Long id, @RequestBody @Valid Airport airport) throws ResourceNotFoundException {
		if(airportService.getAirportById(id)==null) {
			throw new ResourceNotFoundException("Airport with Id: "+ id +" not found");
		}
		airport.setId(id);
		return airportService.saveAirport(airport);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFlight(@PathVariable Long id) throws ResourceNotFoundException {
		airportService.deleteAirport(id);
		return new ResponseEntity<>("Deleted Successfully with id: " + id, HttpStatus.OK);

	}

}
