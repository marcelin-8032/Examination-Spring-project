package com.cegefos.tp1.mapper;

import com.cegefos.tp1.dto.ExamenDto;
import com.cegefos.tp1.entity.Examen;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ExamenMapper {
    ExamenDto toExamenDto(Examen examen);
    Examen toExamen(ExamenDto examenDto);
    Collection<ExamenDto> toExamenDtos(Collection<Examen> examen);
    Collection<Examen> toExamens(Collection<ExamenDto> examenDtos);

}
