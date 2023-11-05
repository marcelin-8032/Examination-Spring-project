package com.examination.project.domain.usecases.v1.subject;

import java.util.Collection;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.domain.Example;
import com.examination.project.domain.entities.SubjectModule;

public interface SubjectUseCase {

	Either<ExaminationException, Void> createSubject(Subject subject);

	Either<ExaminationException, Void> updateSubject(Integer id, int coefficient) throws Exception;

	Either<ExaminationException, Collection<Subject>> getSubjectsGreaterThanACoefficient(int coefficient);

	Either<ExaminationException, Option<Subject>> getSubjectByExample(Example<?> example);

	Either<ExaminationException, Option<Subject>> getSubjectByCoefficient(Example<?> example);

	Either<ExaminationException, Option<Subject>> getSubjectByTitleWithIgnoreCase(Example<?> example);

	Either<ExaminationException, Collection<Subject>> getAllSubjects();

	Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerTitleEqDataModuleEq2(int coeff, SubjectModule subjectModule);

	Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerThanModuleEq2(int coeff, SubjectModule subjectModule);

	Either<ExaminationException, Collection<Subject>> getSubjectTitleEqDataModuleEq2(SubjectModule subjectModule);
}
