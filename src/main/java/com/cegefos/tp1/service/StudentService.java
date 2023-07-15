package com.cegefos.tp1.service;

import java.util.Collection;

import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import io.vavr.control.Either;

public interface StudentService {

	void createEtudiant(StudentEntity studentEntity);

	Either<ExaminationException,Student> createStudent(Student student);

	Collection<StudentEntity> findEtudiants();

	Collection<StudentEntity> findEtudiantByClasse(Classe classe);

}
