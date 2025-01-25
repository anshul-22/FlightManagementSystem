package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.repository.AirportRepository;
import com.pjsoft.fms.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	private AirportRepository airportRepository;

	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@Override
	public Airport getAirportById(Long id) throws ResourceNotFoundException {
		return airportRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Airport with id: "+id+" not found!"));

	}

	@Override
	public Airport saveAirport(Airport airport) {
		return airportRepository.save(airport);

	}

	@Override
	public void deleteAirport(Long id) throws ResourceNotFoundException{
		if(airportRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Airport with id: "+id+" not found");
		}
		airportRepository.deleteById(id);
	}

}
