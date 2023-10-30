package com.examination.project.domain.usecases.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.Collection;


public interface StudentUseCase {

	Either<ExaminationException, Student> createStudent(Student student);

	Either<ExaminationException, Collection<Student>> findStudents();

	Either<ExaminationException, Collection<Student>> findStudentByClasse(Classe classe);
}
