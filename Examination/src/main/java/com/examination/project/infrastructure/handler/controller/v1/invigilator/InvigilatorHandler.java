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


    @Tag(name = " Invigilator API", description = "find all Invigilators")
    @Operation(summary = "find all Invigilator", description = "Returns list of Invigilator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Collection<Invigilator>> getAllInvigilators();

    @Tag(name = " Invigilator API", description = "delete Invigilator by Id")
    @Operation(summary = "delete Invigilator by Id", description = "delete Invigilator by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Void> deleteInvigilatorById(Integer integer);


    @Tag(name = " Invigilator API", description = "delete Invigilators")
    @Operation(summary = "delete Invigilators", description = "delete Invigilators")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Invigilator.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found Invigilator")
    })
    ResponseEntity<Void> deleteAllInvigilators();
}
