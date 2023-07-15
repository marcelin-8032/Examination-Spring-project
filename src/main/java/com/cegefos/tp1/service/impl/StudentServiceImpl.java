package com.cegefos.tp1.service.impl;

import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.exception.ExaminationExceptionSanitize;
import com.cegefos.tp1.persistance.mapper.StudentMapper;
import com.cegefos.tp1.persistance.repository.StudentRepository;
import com.cegefos.tp1.service.StudentService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    @Override
    public Either<ExaminationException, Student> createStudent(Student student) {
        return Try.of(() -> this.studentMapper.toStudentEntity(student))
                .map(this.studentRepository::save)
                .map(this.studentMapper::toStudent)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Student>> findStudents() {
        return Try.of(this.studentRepository::findAll)
                .map(this.studentMapper::toStudents)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Student>> findStudentByClasse(Classe classe) {
        return Try.of(() -> this.studentRepository.findStudentsByClasse(classe))
                .map(this.studentMapper::toStudents)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

}
