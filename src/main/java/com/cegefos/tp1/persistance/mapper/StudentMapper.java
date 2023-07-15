package com.cegefos.tp1.persistance.mapper;

import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentEntity studentEntity);
    StudentEntity toStudentEntity(Student student);
    Collection<Student> toStudents(Collection<StudentEntity> etudiantEntities);
    Collection<StudentEntity> toStudentEntities(Collection<Student> students);

}
