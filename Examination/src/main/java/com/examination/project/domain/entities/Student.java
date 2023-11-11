package com.examination.project.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
public record Student(

        @Schema(name = "studentId", requiredMode = NOT_REQUIRED)
        Integer studentId,

        @Schema(name = "name", requiredMode = REQUIRED)
        String name,

        @Schema(name = "classe", requiredMode = REQUIRED)
        Classe classe,

        @Schema(name = "studentExams", requiredMode = REQUIRED)
        Set<Exam> exams
) {
}
