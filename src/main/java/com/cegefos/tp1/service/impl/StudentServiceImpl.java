package com.cegefos.tp1.service.impl;

import java.util.Collection;

import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.exception.ExaminationExceptionSanitize;
import com.cegefos.tp1.persistance.mapper.StudentMapper;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.persistance.repository.StudentRepository;
import com.cegefos.tp1.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Override
    public void createEtudiant(StudentEntity studentEntity) {
        this.studentRepository.save(studentEntity);
    }

    @Override
    public Either<ExaminationException, Student> createStudent(Student student) {
        return Try.of(() -> this.studentMapper.toStudentEntity(student))
                .map(this.studentRepository::save)
                .map(this.studentMapper::toStudent)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Collection<StudentEntity> findEtudiantByClasse(Classe classe) {
        return studentRepository.findEtudiantByClasse(classe);
    }


    @Override
    public Collection<StudentEntity> findEtudiants() {
        return studentRepository.findAll();
    }


}
