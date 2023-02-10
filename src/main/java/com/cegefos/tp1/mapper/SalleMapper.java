package com.cegefos.tp1.mapper;

import com.cegefos.tp1.dto.SalleDto;
import com.cegefos.tp1.entity.Salle;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SalleMapper {
    SalleDto toSalleDto(Salle salle);

    Salle toSalle(SalleDto salleDto);

    Collection<SalleDto> toSalleDtos(Collection<Salle> salle);

    Collection<Salle> toSalles(Collection<SalleDto> salleDtos);
}
