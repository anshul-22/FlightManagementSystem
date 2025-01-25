package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Airport;

public interface AirportService {
	List<Airport> getAllAirports() ;
	Airport getAirportById(Long id) throws ResourceNotFoundException ;
	Airport saveAirport(Airport airport);
	void deleteAirport(Long id) throws ResourceNotFoundException;

}
