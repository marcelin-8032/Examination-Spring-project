package com.examination.project.infrastructure.usecaseImpl.v1.subject;

import com.examination.project.domain.entities.Module;
import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.infrastructure.mapper.SubjectMapper;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import com.examination.project.infrastructure.persistance.subject.entities.QSubjectEntity;
import com.examination.project.infrastructure.persistance.subject.repository.SubjectRepository;
import com.querydsl.core.types.Predicate;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
    public Either<ExaminationException, Void> updateSubject(Integer id, int coefficient) throws Exception {
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
    public Either<ExaminationException, Option<Subject>> getSubjectByExample(Example<?> example) {
        //Matiere matiere=matiereRepository.findAll(null);
        return Try.of(() -> subjectRepository.findOne((Predicate) example))
                .map(this.subjectMapper::unwrapReferenceToOption)
                //  .map(Option::ofOptional)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Option<Subject>> getSubjectByCoefficient(Example<?> example) {
        var subject = Subject.builder()
                .coefficient(175)
                .build();
        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());

        return Try.of(() -> Example.of(subject, matcher))
                .map(subjectExample -> this.subjectRepository.findOne((Predicate) example))
                .map(this.subjectMapper::unwrapReferenceToOption)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Option<Subject>> getSubjectByTitleWithIgnoreCase(Example<?> example) {

        var subject = Subject.builder().coefficient(200).title("DATA").build();
        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();

        return Try.of(() -> Example.of(subject, matcher))
                .map(subjectExample -> this.subjectRepository.findOne((Predicate) example))
                .map(this.subjectMapper::unwrapReferenceToOption)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getAllSubjects() {
        return Try.of(() -> this.subjectRepository.findAll())
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerTitleEqDataModuleEq2(int coeff, Module module) {
        var qMatiere = new QSubjectEntity("matiere");
        var filterByCoeff = qMatiere.coefficient.gt(coeff);
        var filterByIntitule = qMatiere.title.contains("data");
        var filterByModule = qMatiere.module.eq(module);

        return Try.of(() -> this.subjectRepository.findAll(filterByCoeff.and(filterByIntitule).and(filterByModule)))
                .map(subjectEntities -> subjectEntities.iterator().next())
                .map(List::of)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectCoeffBiggerThanModuleEq2(int coeff, Module module) {
        var qMatiere = new QSubjectEntity("matiere");
        var filterByCoeff = qMatiere.coefficient.gt(coeff);
        var filterByModule = qMatiere.module.eq(module);

        return Try.of(() -> this.subjectRepository.findAll(filterByCoeff.and(filterByModule)))
                .map(subjectEntities -> subjectEntities.iterator().next())
                .map(List::of)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Subject>> getSubjectTitleEqDataModuleEq2(Module module) {
        var qMatiere = new QSubjectEntity("matiere");
        var filterByIntitule = qMatiere.title.contains("data");
        var filterByModule = qMatiere.module.eq(module);

        return Try.of(() -> this.subjectRepository.findAll(filterByIntitule.and(filterByModule)))
                .map(subjectEntities -> subjectEntities.iterator().next())
                .map(List::of)
                .map(this.subjectMapper::toSubjects)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

}
