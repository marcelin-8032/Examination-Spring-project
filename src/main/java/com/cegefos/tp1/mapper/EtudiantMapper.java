package com.cegefos.tp1.mapper;

import com.cegefos.tp1.dto.EtudiantDto;
import com.cegefos.tp1.entity.Etudiant;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantDto toEtudiantDto(Etudiant etudiant);
    Etudiant toEtudiant(EtudiantDto etudiantDto);
    Collection<EtudiantDto> toEtudiantDtos(Collection<Etudiant> etudiants);
    Collection<Etudiant> toEtudiants(Collection<EtudiantDto> etudiantDtos);

}
