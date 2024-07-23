package com.examination.project.domain.usecases.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.Collection;

public interface SubjectUseCase {

    Either<ExaminationException, Void> createSubject(Subject subject);

    Either<ExaminationException, Void> updateSubjectCoefficient(Integer id, int coefficient) throws Exception;

    Either<ExaminationException, Collection<Subject>> getSubjectsGreaterThanACoefficient(int coefficient);

    Either<ExaminationException, Collection<Subject>> getAllSubjects();

    Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerTitleEqDataModuleEq2(int coeff, SubjectModule subjectModule);

    Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerThanModuleEq2(int coeff, SubjectModule subjectModule);

    Either<ExaminationException, Collection<Subject>> getSubjectsTitleEqDataScienceModuleEq2(SubjectModule subjectModule);

    Either<ExaminationException, Option<Subject>> getSubjectByExample(Subject subject);

    Either<ExaminationException, Collection<Subject>> getSubjectByCoefficient(String title, int coefficient);

    Either<ExaminationException, Collection<Subject>> getSubjectByTitleWithIgnoreCase(String title);
}
