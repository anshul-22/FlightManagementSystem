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

import com.pjsoft.fms.dto.BookingDTO;
import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.mapper.BookingMapper;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
    private BookingService bookingService;
	
	@Autowired
	private BookingMapper bookingMapper;

    @GetMapping
    public List<Booking> getAllBooking() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookingById(@PathVariable Long id) throws ResourceNotFoundException {
    	Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingDTO bookingDTO) throws ResourceNotFoundException {
        return bookingService.saveBooking(bookingMapper.dtoToEntity(bookingDTO));
    }

    @PutMapping("/{id}")
    public Booking updatePassenger(@PathVariable Long id, @RequestBody Booking booking) throws ResourceNotFoundException {
    	if(bookingService.getBookingById(id)==null) {
			throw new ResourceNotFoundException("Booking with Id: "+ id +" not found");
		}
        booking.setId(id);
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) throws ResourceNotFoundException {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>( "Deleted Successfully with id: "+id,HttpStatus.OK);

    }

}
