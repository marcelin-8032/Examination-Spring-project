package com.examination.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
@With
public record Subject(

        @Schema(name = "subjectId", requiredMode = NOT_REQUIRED)
        Integer subjectId,

        @Schema(name = "title", requiredMode = REQUIRED)
        String title,

        @Schema(name = "coefficient", requiredMode = REQUIRED)
        int coefficient,

        @Schema(name = "subjectModule", requiredMode = REQUIRED)
        SubjectModule subjectModule,

        @JsonIgnore
        @Schema(name = "subjectExams", requiredMode = NOT_REQUIRED)
        Set<Exam> exams
) {
}
