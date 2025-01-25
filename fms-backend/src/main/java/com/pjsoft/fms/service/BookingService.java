package com.pjsoft.fms.service;

import java.util.List;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Booking;

public interface BookingService {
	List<Booking> getAllBookings();
	Booking getBookingById(Long id) throws ResourceNotFoundException;
	Booking saveBooking(Booking booking);
	void deleteBooking(Long id) throws ResourceNotFoundException;

}
