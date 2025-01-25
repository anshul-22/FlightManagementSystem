package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.dto.PassengerDTO;
import com.pjsoft.fms.model.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
	
	@Mapping(source = "email", target = "email", qualifiedByName = "toUpperCase")
	Passenger dtoToEntityMapper(PassengerDTO dto);
	
	@Named("toUpperCase")
	static String toUpperCase(String name) {
		return name.toUpperCase();
	}

}
