package com.examination.project.infrastructure.usecaseImpl.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Student;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.infrastructure.mapper.struct.ExamMapper;
import com.examination.project.infrastructure.mapper.struct.StudentMapper;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.student.repository.StudentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Slf4j
@RequiredArgsConstructor
@Service
public class StudentUseCaseImpl implements StudentUseCase {

    private final StudentRepository studentRepository;

    private final ExamRepository examRepository;

    private final StudentMapper studentMapper;

    private final ExamMapper examMapper;

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


    @Override
    public Either<ExaminationException, Void> addOrUpdateStudentToExam(int examId, Student student) {

        return Try.run(() -> this.examRepository.findById(examId).map(
                        examEntity -> {
                            var studentEntity = this.studentMapper.toStudentEntity(student);
                            if (studentEntity.getStudentId() != Integer.parseInt(null)) {
                                studentEntity.getExamEntities().add(examEntity);
                                return this.studentRepository.save(studentEntity);
                            }
                            return null;
                        }
                ))
//                        .ifPresent(examEntity -> {
//
//                                    studentEntity.addExam(examEntity);
//                                    this.studentRepository.save(studentEntity);
//                                    // examEntity.getStudents().add(this.studentMapper.toStudentEntity(student));
//                                    // this.examRepository.save(examEntity);
//                                    // this.studentRepository.save(this.studentMapper.toStudentEntity(student));
//                                }
//                        ))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException,  Collection<Exam>> fetchExamsAssignedToSpecificStudent(Integer studentId) {

        return Try.of(()->this.examRepository.findExamsByStudentId(studentId))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
