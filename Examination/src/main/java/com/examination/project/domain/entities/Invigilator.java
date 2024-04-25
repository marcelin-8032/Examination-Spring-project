package com.examination.project.domain.entities;

import com.examination.project.domain.validation.InvigilatorValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.With;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


@Builder
@With
@InvigilatorValidation
public record Invigilator(

        @Schema(name = "invigilatorId", requiredMode = NOT_REQUIRED)
        Integer invigilatorId,

        @Schema(name = "firstName", requiredMode = REQUIRED)
        String firstName,

        @Schema(name = "lastName", requiredMode = REQUIRED)
        String lastName,

        @Schema(name = "identificationNumber", requiredMode = REQUIRED)
        Integer identificationNumber
) {
}
