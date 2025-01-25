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
import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.service.impl.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

	@Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedule() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getScheduleById(@PathVariable Long id) throws ResourceNotFoundException {
    	Schedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public Schedule createPassenger(@RequestBody Schedule schedule) throws ResourceNotFoundException {
        return scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updatePassenger(@PathVariable Long id, @RequestBody Schedule schedule) throws ResourceNotFoundException {
    	if(scheduleService.getScheduleById(id)==null) {
			throw new ResourceNotFoundException("Schedule with Id: "+ id +" not found");
		}
        schedule.setId(id);
        return scheduleService.saveSchedule(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) throws ResourceNotFoundException {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>( "Deleted Successfully with id: "+id,HttpStatus.OK);

    }
}
