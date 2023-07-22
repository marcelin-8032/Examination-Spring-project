package com.examination.project.usecases.student;

import java.util.Collection;


import com.examination.project.entities.Student;
import com.examination.project.exception.ExaminationException;
import com.examination.project.enums.Classe;
import io.vavr.control.Either;

public interface StudentUseCase {

	Either<ExaminationException, Student> createStudent(Student student);

	Either<ExaminationException, Collection<Student>> findStudents();

	Either<ExaminationException, Collection<Student>> findStudentByClasse(Classe classe);
}
