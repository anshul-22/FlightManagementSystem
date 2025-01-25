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

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.service.impl.ScheduledFlightService;

@RestController
@RequestMapping("/api/scheduled-flights")
public class ScheduledFlightController {

	@Autowired
    private ScheduledFlightService scheduledFlightService;

    @GetMapping
    public List<ScheduledFlight> getAllScheduledFlight() {
        return scheduledFlightService.getAllScheduledFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getScheduledFlightById(@PathVariable Long id) throws ResourceNotFoundException {
    	ScheduledFlight scheduledFlight = scheduledFlightService.getScheduledFlightById(id);
        return ResponseEntity.ok(scheduledFlight);
    }

    @PostMapping
    public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) throws ResourceNotFoundException {
        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
    }

    @PutMapping("/{id}")
    public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight) throws ResourceNotFoundException {
    	if(scheduledFlightService.getScheduledFlightById(id)==null) {
			throw new ResourceNotFoundException("Scheduled Flight with Id: "+ id +" not found");
		}
        scheduledFlight.setId(id);
        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScheduledFlight(@PathVariable Long id) throws ResourceNotFoundException {
        scheduledFlightService.deleteScheduledFlight(id);
        return new ResponseEntity<>( "Deleted Successfully with id: "+id,HttpStatus.OK);

    }
}
