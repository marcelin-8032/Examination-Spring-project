package com.examination.project.persistance.mapper;

import com.examination.project.persistance.entities.StudentEntity;
import com.examination.project.domain.Student;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentEntity studentEntity);
    StudentEntity toStudentEntity(Student student);
    Collection<Student> toStudents(Collection<StudentEntity> studentEntities);
    Collection<StudentEntity> toStudentEntities(Collection<Student> students);

}
