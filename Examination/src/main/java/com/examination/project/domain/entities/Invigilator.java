package com.examination.project.domain.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.With;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
public record Invigilator(

        @Schema(name = "invigilatorId", requiredMode = NOT_REQUIRED)
        Integer invigilatorId,

        @Schema(name = "examName", requiredMode = REQUIRED)
        String name
) {
}
