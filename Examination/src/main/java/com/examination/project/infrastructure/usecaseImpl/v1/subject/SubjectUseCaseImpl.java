package com.examination.project.infrastructure.usecaseImpl.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.mapper.struct.SubjectMapper;
import com.examination.project.infrastructure.persistance.subject.entities.QSubjectEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.StreamSupport;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Slf4j
@RequiredArgsConstructor
@Service
public class SubjectUseCaseImpl implements SubjectUseCase {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    @Override
    public Either<ExaminationException, Void> createSubject(Subject subject) {
        return Try.run(() -> {
                    var subjectEntity = this.subjectMapper.toSubjectEntity(subject);
                    this.subjectRepository.save(subjectEntity);
                })
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> updateSubjectCoefficient(Integer id, int coefficient) throws Exception {
        return Try.run(() -> this.subjectRepository.findById(id).ifPresent(
                        subjectEntity -> {
                            subjectEntity.setCoefficient(coefficient);
                            this.subjectRepository.save(subjectEntity);
                        })).onFailure(cause -> log.error("there is a problem in updating coefficient number"))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectsGreaterThanACoefficient(int coefficient) {
        return Try.of(() -> this.subjectRepository.findByCoefficientGreaterThan(coefficient))
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getAllSubjects() {
        return Try.of(this.subjectRepository::findAll)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerTitleEqDataModuleEq2(int coeff, SubjectModule subjectModule) {

        val subjectEntity = QSubjectEntity.subjectEntity;
        val filterByCoeff = subjectEntity.coefficient.gt(coeff);
        val filterByTitle = subjectEntity.title.contains("Chemistry");
        val filterByModule = subjectEntity.subjectModule.eq(subjectModule);

        return Try.of(() -> this.subjectRepository.findAll(filterByCoeff.and(filterByTitle).and(filterByModule)))
                .map(iterable -> StreamSupport.stream(iterable.spliterator(), false).toList())
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerThanModuleEq2(int coeff, SubjectModule subjectModule) {

        val qSubjectEntity = QSubjectEntity.subjectEntity;
        val filterByCoeff = qSubjectEntity.coefficient.gt(coeff);
        val filterByModule = qSubjectEntity.subjectModule.eq(subjectModule);

        return Try.of(() -> this.subjectRepository.findAll(filterByCoeff.and(filterByModule)))
                .map(iterable -> StreamSupport.stream(iterable.spliterator(), false).toList())
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectsTitleEqDataScienceModuleEq2(SubjectModule subjectModule) {

        val qSubjectEntity = QSubjectEntity.subjectEntity;
        val filterByTitle = qSubjectEntity.title.contains("Data_Science");
        val filterByModule = qSubjectEntity.subjectModule.eq(subjectModule);

        return Try.of(() -> this.subjectRepository.findAll(filterByTitle.and(filterByModule)))
                .map(iterable -> StreamSupport.stream(iterable.spliterator(), false).toList())
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Option<Subject>> getSubjectByExample(Subject subject) {

        return Try.of(() -> this.subjectMapper.toSubjectEntity(subject))
                .map(subjectEntity1 -> Example.of(subjectEntity1, ExampleMatcher.matchingAll().withIgnoreCase()))
                .map(this.subjectRepository::findOne)
                .map(this.subjectMapper::unwrapReferenceToOption)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectByCoefficientAndTitle(String title, int coefficient) {

        val subjectEntity = SubjectEntity.builder()
                .title(title)
                .coefficient(coefficient)
                .build();

        return Try.of(() -> Example.of(subjectEntity, this.getSubjectMatcher()
                        .withMatcher("title", contains())
                        .withMatcher("coefficient", exact())))
                .map(this.subjectRepository::findAll)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectByTitleWithIgnoreCase(String title) {

        val subjectEntity = SubjectEntity.builder()
                .title(title)
                .build();

        return Try.of(() -> Example.of(subjectEntity, this.getSubjectMatcher()
                        .withIgnorePaths("coefficient").withIgnoreNullValues()
                        .withMatcher("title", contains().ignoreCase())))
                .map(this.subjectRepository::findAll)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    private ExampleMatcher getSubjectMatcher() {
        return ExampleMatcher.matchingAll()
                .withIgnorePaths("subjectId").withIgnoreNullValues()
                .withIgnorePaths("subjectModule").withIgnoreNullValues()
                .withIgnorePaths("createDate").withIgnoreNullValues()
                .withIgnorePaths("createdBy").withIgnoreNullValues()
                .withIgnorePaths("modifiedDate").withIgnoreNullValues()
                .withIgnorePaths("modifiedBy").withIgnoreNullValues()
                .withIgnorePaths("examEntities").withIgnoreNullValues();
    }
}
