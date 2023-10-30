package com.examination.project.domain.entities;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;

@Builder
@With
public record Subject(
        Integer subjectId,
        String title,
        int coefficient,
        Module module,

        Set<Exam> exams) {
}
