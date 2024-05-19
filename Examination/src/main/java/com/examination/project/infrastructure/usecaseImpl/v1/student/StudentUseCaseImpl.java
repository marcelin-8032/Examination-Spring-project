package com.examination.project.infrastructure.usecaseImpl.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Student;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import com.examination.project.infrastructure.mapper.struct.ExamMapper;
import com.examination.project.infrastructure.mapper.struct.StudentMapper;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.student.repository.StudentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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
    public Either<ExaminationException, Void> addOrUpdateStudentToExam(Integer examId, Integer studentId) {

        return Try.run(() -> this.examRepository.findById(examId).map(examEntity -> {
                    val studentEntity = this.studentRepository.findById(studentId);
                    studentEntity.ifPresent(student -> {
                                student.getExamEntities().add(examEntity);
                                this.studentRepository.save(student);
                            }
                    );
                    return null;
                }))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }


    @Override
    public Either<ExaminationException, Collection<Exam>> fetchExamsAssignedToSpecificStudent(Integer studentId) {

        return Try.of(() -> this.examRepository.findExamsByStudentId(studentId))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> deleteStudent(Integer examId, Integer studentId) {

        return Try.run(() -> this.examRepository.findById(studentId)
                        .map(examEntity -> {
                            val studentEntity = this.studentRepository.findById(studentId);

                            studentEntity.ifPresent(student -> {
                                this.studentRepository.deleteById(studentId);
                                this.examRepository.deleteById(examId);
                            });
                            return null;
                        }))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
