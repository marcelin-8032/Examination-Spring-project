package com.examination.project.domain.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.NoArgsConstructor;
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
        SubjectModule subjectModule
) {

}
