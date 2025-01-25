package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.dto.FlightDTO;
import com.pjsoft.fms.model.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {

	@Mapping(source = "carrierName", target = "carrierName", qualifiedByName = "toUpperCase")
	Flight dtoToEntityMapper(FlightDTO dto);

	@Named("toUpperCase")
	static String toUpperCase(String name) {
		return name.toUpperCase();

	}
}
