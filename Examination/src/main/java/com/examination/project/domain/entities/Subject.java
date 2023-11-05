package com.examination.project.domain.entities;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

@Builder
@With
public record Subject(
        Integer subjectId,
        String title,
        int coefficient,
        SubjectModule subjectModule,

        Set<Exam> exams) {
}
