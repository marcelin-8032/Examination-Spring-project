package com.examination.project.mapper;


import com.examination.project.entities.Invigilator;
import com.examination.project.persistance.invigilator.entities.InvigilatorEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface InvigilatorMapper {

    Invigilator toInvigilator(InvigilatorEntity invigilatorEntity);

    InvigilatorEntity toInvigilatorEntity(Invigilator invigilator);

    Collection<Invigilator> toInvigilators(Collection<InvigilatorEntity> invigilatorEntities);

    Collection<InvigilatorEntity> toInvigilatorEntities(Collection<Invigilator> invigilators);


}
