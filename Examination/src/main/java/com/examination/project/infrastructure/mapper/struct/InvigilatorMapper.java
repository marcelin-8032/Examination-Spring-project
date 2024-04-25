package com.examination.project.infrastructure.mapper.struct;


import com.examination.project.domain.entities.Invigilator;
import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface InvigilatorMapper {

    Invigilator toInvigilator(InvigilatorEntity invigilatorEntity);

    InvigilatorEntity toInvigilatorEntity(Invigilator invigilator);

    Collection<Invigilator> toInvigilators(Collection<InvigilatorEntity> invigilatorEntities);

    Collection<InvigilatorEntity> toInvigilatorEntities(Collection<Invigilator> invigilators);
}
