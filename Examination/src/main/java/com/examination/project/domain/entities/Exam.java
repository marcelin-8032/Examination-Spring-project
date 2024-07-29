package com.examination.project.domain.entities;

import com.examination.project.domain.validation.ExamValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.With;

import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
@ExamValidation
public record Exam(
        @Schema(name = "examId", requiredMode = NOT_REQUIRED)
        Integer examId,

        @Schema(name = "examName", requiredMode = REQUIRED)
        String examName,

        @Schema(name = "examDate", requiredMode = REQUIRED)
        LocalDateTime examDate,

        @Schema(name = "subject", requiredMode = REQUIRED)
        Subject subject,

        @Schema(name = "room", requiredMode = REQUIRED)
        Room room,

        @Schema(name = "invigilator", requiredMode = REQUIRED)
        Invigilator invigilator
) {
}
