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

import com.pjsoft.fms.dto.PassengerDTO;
import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.PassengerMapper;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.service.impl.PassengerService;
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

	@Autowired
    private PassengerService passengerService;
	@Autowired
	private PassengerMapper passengerMapper;

    @GetMapping
    public List<Passenger> getAllPassenger() {
        return passengerService.getAllPassenger();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPassengerById(@PathVariable Long id) throws ResourceNotFoundException {
        Passenger passenger = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passenger);
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody PassengerDTO passengerDto) throws ResourceNotFoundException {
        return passengerService.savePassenger(passengerMapper.dtoToEntityMapper(passengerDto));
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) throws ResourceNotFoundException {
    	if(passengerService.getPassengerById(id)==null) {
			throw new ResourceNotFoundException("Passenger with Id: "+ id +" not found");
		}
        passenger.setId(id);
        return passengerService.savePassenger(passenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) throws ResourceNotFoundException {
        passengerService.deletePassenger(id);
        return new ResponseEntity<>( "Deleted Successfully with id: "+id,HttpStatus.OK);

    }

}
