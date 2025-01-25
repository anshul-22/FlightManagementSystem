package com.pjsoft.fms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pjsoft.fms.dto.AirportDTO;
import com.pjsoft.fms.model.Airport;



@Mapper(componentModel = "spring")
public interface AirportMapper {

	@Mapping(source = "name", target = "name")
	AirportDTO entityToDtoMapper(Airport airport);

//	@Mapping(source = "name", target = "name", qualifiedByName = "toUpperCase")
	Airport dtoToEntityMapper(AirportDTO dto);

}
