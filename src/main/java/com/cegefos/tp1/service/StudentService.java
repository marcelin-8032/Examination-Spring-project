package com.cegefos.tp1.service;

import java.util.Collection;


import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import io.vavr.control.Either;

public interface StudentService {

	Either<ExaminationException,Student> createStudent(Student student);

	Either<ExaminationException, Collection<Student>> findStudents();

	Either<ExaminationException, Collection<Student>> findStudentByClasse(Classe classe);
}
