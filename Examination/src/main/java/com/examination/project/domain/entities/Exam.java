package com.examination.project.domain.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.*;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;


@Builder
@With
public record Exam(
        @Schema(name = "examId", requiredMode = NOT_REQUIRED)
        Integer examId,

        @Schema(name = "name", requiredMode = REQUIRED)
        String name,

        @Schema(name = "date of exam", requiredMode = REQUIRED)
        LocalDateTime dateExam,

        @Schema(name = "students", requiredMode = REQUIRED)
        Set<Student> students,

        @Schema(name = "subject", requiredMode = REQUIRED)
        Subject subject,

        @Schema(name = "room", requiredMode = REQUIRED)
        Room room,

        @Schema(name = "invigilator", requiredMode = REQUIRED)
        Invigilator invigilator
) {

}
