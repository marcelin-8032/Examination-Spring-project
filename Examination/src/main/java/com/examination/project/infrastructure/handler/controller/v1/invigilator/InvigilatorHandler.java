package com.examination.project.infrastructure.handler.controller.v1.invigilator;


import com.examination.project.domain.entities.Invigilator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;


@Tag(name = " Invigilator API", description = "Management APIs for Invigilator")
public interface InvigilatorHandler {

    @Operation(summary = "add Invigilator", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Invigilator.class))
            }),
    })
    ResponseEntity<Void> createAnInvigilator(@RequestBody Invigilator invigilator);

    @Operation(summary = "find all Invigilator", description = "Return list of Invigilator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Invigilator>> getAllInvigilators();

    @Operation(summary = "delete Invigilator by Id", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
    })
    ResponseEntity<Void> deleteInvigilatorById(Integer integer);

    @Operation(summary = "delete Invigilators", description = "Return nothing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
    })
    ResponseEntity<Void> deleteAllInvigilators();
}
