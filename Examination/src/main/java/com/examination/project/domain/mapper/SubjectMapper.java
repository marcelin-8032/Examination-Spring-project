package com.examination.project.domain.mapper;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import io.vavr.control.Option;
import org.mapstruct.Mapper;
import org.springframework.data.annotation.Reference;

import java.util.Collection;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectEntity subjectEntity);

    @Reference
    static <T> T unwrapReference(Optional<T> optional) {
        return optional.orElse(null);
    }

    @Reference
    default Option<Subject> unwrapReferenceToOption(Optional<SubjectEntity> optionalSubjectEntity) {
        return (optionalSubjectEntity.isPresent() ? Option.ofOptional(optionalSubjectEntity.map(this::toSubject)) : null);
    }
    SubjectEntity toSubjectEntity(Subject subject);

    Collection<Subject> toSubjects(Collection<SubjectEntity> subjectEntities);

    Collection<SubjectEntity> toSubjectEntities(Collection<Subject> subjects);
}
