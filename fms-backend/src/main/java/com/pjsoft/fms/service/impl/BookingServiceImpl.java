package com.pjsoft.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.repository.BookingRepository;
import com.pjsoft.fms.service.BookingService;
@Service
public class BookingServiceImpl  implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(Long id) throws ResourceNotFoundException {
		return bookingRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Booking with id: "+id+" not found!"));

	}

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);

	}

	@Override
	public void deleteBooking(Long id) throws ResourceNotFoundException{
		if(bookingRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Booking with id: "+id+" not found");
		}
		bookingRepository.deleteById(id);
	}

}
