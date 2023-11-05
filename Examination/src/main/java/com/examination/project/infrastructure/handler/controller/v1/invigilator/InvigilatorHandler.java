package com.examination.project.infrastructure.handler.controller.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface InvigilatorHandler {

    @Tag(name = " Invigilator API", description = "adding an Invigilator")
    @Operation(summary = "add Invigilator", description = "Returns an Invigilator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Invigilator.class))
            }),
    })
    ResponseEntity<Void> createAnInvigilator(@RequestBody Invigilator invigilator);
}
