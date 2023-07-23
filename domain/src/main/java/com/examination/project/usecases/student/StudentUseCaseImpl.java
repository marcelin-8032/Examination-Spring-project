package com.examination.project.usecases.student;

import com.examination.project.entities.Classe;
import com.examination.project.entities.Student;
import com.examination.project.exception.ExaminationException;
import com.examination.project.exception.ExaminationExceptionSanitize;
import com.examination.project.mapper.StudentMapper;
import com.examination.project.handler.persistance.student.repository.StudentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@Slf4j
public class StudentUseCaseImpl implements StudentUseCase {

    private StudentRepository studentRepository;

    @Autowired
    private  StudentMapper studentMapper;


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
//        return Try.of(() -> this.studentRepository.findStudentsByClasse(classe))
//                .map(this.studentMapper::toStudents)
//                .toEither()
//                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
        return null;
    }

}
