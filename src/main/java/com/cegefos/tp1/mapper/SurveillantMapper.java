package com.cegefos.tp1.mapper;

import com.cegefos.tp1.domains.Invigilator;
import com.cegefos.tp1.persistance.entities.InvigilatorEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SurveillantMapper {

    Invigilator toSurveillantDto(InvigilatorEntity invigilatorEntity);

    InvigilatorEntity toSurveillant(Invigilator invigilator);

    Collection<Invigilator> toSurveillantDtos(Collection<InvigilatorEntity> surveillantEntities);

    Collection<InvigilatorEntity> toSurveillants(Collection<Invigilator> invigilators);


}
