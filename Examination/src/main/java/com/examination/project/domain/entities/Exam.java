package com.examination.project.domain.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.With;

import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
public record Exam(

        @Schema(name = "examId", requiredMode = NOT_REQUIRED)
        Integer examId,

        @Schema(name = "name", requiredMode = REQUIRED)
        String name,

        @Schema(name = "dateExam", requiredMode = REQUIRED)
        LocalDateTime dateExam,

        @Schema(name = "subject", requiredMode = REQUIRED)
        Subject subject,

        @Schema(name = "room", requiredMode = REQUIRED)
        Room room,

        @Schema(name = "invigilator", requiredMode = REQUIRED)
        Invigilator invigilator
) {
}
