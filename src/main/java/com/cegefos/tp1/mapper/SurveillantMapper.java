package com.cegefos.tp1.mapper;

import com.cegefos.tp1.dto.SurveillantDto;
import com.cegefos.tp1.entity.Surveillant;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SurveillantMapper {

    SurveillantDto toSurveillantDto(Surveillant surveillant);

    Surveillant toSurveillant(SurveillantDto surveillantDto);

    Collection<SurveillantDto> toSurveillantDtos(Collection<Surveillant> surveillants);

    Collection<Surveillant> toSurveillants(Collection<SurveillantDto> surveillantDtos);


}
