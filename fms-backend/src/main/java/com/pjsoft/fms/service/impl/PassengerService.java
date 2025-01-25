package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.repository.PassengerRepository;
@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	public List<Passenger> getAllPassenger() {
		return passengerRepository.findAll();
	}

	public Passenger getPassengerById(Long id) throws ResourceNotFoundException {
		return passengerRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Passenger with id: "+id+" not found!"));

	}

	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);

	}

	public void deletePassenger(Long id) throws ResourceNotFoundException{
		if(passengerRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Passenger with id: "+id+" not found");
		}
		passengerRepository.deleteById(id);
	}
}
