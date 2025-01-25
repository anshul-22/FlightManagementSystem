package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.dto.BookingDTO;
import com.pjsoft.fms.model.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
	@Mapping(source = "status", target = "status", qualifiedByName = "toUpperCase")
	Booking dtoToEntity(BookingDTO dto);
	
	@Named("toUpperCase")
	static String toUpperCase(String name) {
		return name.toUpperCase();

	}
	

}
