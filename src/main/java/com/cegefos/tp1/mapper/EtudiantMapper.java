package com.cegefos.tp1.mapper;

import com.cegefos.tp1.domains.Student;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    Student toEtudiantDto(StudentEntity studentEntity);
    StudentEntity toEtudiant(Student student);
    Collection<Student> toEtudiantDtos(Collection<StudentEntity> etudiantEntities);
    Collection<StudentEntity> toEtudiants(Collection<Student> students);

}
