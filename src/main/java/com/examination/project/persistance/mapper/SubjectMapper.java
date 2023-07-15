package com.examination.project.persistance.mapper;

import com.examination.project.domain.Subject;
import com.examination.project.persistance.entities.SubjectEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectEntity subjectEntity);
    SubjectEntity toSubjectEntity(Subject subject);
    Collection<Subject> toSubjects(Collection<SubjectEntity> subjectEntities);
    Collection<SubjectEntity> toSubjectEntities(Collection<Subject> subjects);

}
