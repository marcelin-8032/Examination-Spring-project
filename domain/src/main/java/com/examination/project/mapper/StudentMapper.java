package com.examination.project.mapper;

import com.examination.project.entities.Student;
import com.examination.project.handler.persistance.student.entities.StudentEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentEntity studentEntity);
    StudentEntity toStudentEntity(Student student);
    Collection<Student> toStudents(Collection<StudentEntity> studentEntities);
    Collection<StudentEntity> toStudentEntities(Collection<Student> students);

}
