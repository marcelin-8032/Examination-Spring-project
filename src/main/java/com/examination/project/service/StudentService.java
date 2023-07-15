package com.examination.project.service;

import java.util.Collection;


import com.examination.project.domain.Student;
import com.examination.project.exception.ExaminationException;
import com.examination.project.enums.Classe;
import io.vavr.control.Either;

public interface StudentService {

	Either<ExaminationException,Student> createStudent(Student student);

	Either<ExaminationException, Collection<Student>> findStudents();

	Either<ExaminationException, Collection<Student>> findStudentByClasse(Classe classe);
}
