package com.examination.project.domain.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.With;

import java.time.Instant;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
public record Student(

        @Schema(name = "studentId", requiredMode = NOT_REQUIRED)
        Integer studentId,

        @Schema(name = "firstName", requiredMode = REQUIRED)
        String firstName,

        @Schema(name = "lastName", requiredMode = REQUIRED)
        String lastName,

        @Schema(name = "identificationId", requiredMode = REQUIRED)
        Integer identificationId,

        @Schema(name = "studyYear", requiredMode = REQUIRED)
        Integer studyYear,

        @Schema(name = "birthDay", requiredMode = REQUIRED)
        Instant birthDay,

        @Schema(name = "classe", requiredMode = REQUIRED)
        Classe classe
) {
}
