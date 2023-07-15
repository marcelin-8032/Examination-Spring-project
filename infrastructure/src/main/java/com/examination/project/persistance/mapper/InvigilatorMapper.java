package com.examination.project.persistance.mapper;

import com.examination.project.persistance.entities.InvigilatorEntity;
import com.examination.project.domain.Invigilator;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface InvigilatorMapper {

    Invigilator toInvigilator(InvigilatorEntity invigilatorEntity);

    InvigilatorEntity toInvigilatorEntity(Invigilator invigilator);

    Collection<Invigilator> toInvigilators(Collection<InvigilatorEntity> invigilatorEntities);

    Collection<InvigilatorEntity> toInvigilatorEntities(Collection<Invigilator> invigilators);


}
