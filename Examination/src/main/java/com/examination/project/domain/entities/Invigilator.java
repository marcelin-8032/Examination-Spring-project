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
public record Invigilator(

        @Schema(name = "invigilatorId", requiredMode = NOT_REQUIRED)
        Integer invigilatorId,

        @Schema(name = "name", requiredMode = REQUIRED)
        String name,

        @JsonIgnore
        @Schema(name = "examsInvigilator", requiredMode = NOT_REQUIRED)
        Set<Exam> exams
) {
}
