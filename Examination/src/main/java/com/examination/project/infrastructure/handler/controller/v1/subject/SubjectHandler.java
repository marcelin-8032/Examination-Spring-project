package com.examination.project.infrastructure.handler.controller.v1.subject;


import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface SubjectHandler {

    @Tag(name = " Subject API", description = "add subject")
    @Operation(
            summary = "Add subject",
            description = "add subject",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Void> createSubject(Subject subject);

    @Tag(name = " Subject API", description = "update subject")
    @Operation(
            summary = "Add subject",
            description = "add subject",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Void> updateSubjectCoefficient(Integer subjectId, int number) throws Exception;

    @Tag(name = " Subject API", description = "get subject by coeff bigger than")
    @Operation(
            summary = "get subject bigger than",
            description = "get subject bigger than",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff);

    ResponseEntity<Collection<Subject>> getAllSubjects();

    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            int coeff,
            SubjectModule subjectModule);

    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(
            int coeff,
            SubjectModule subjectModule);

    ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(SubjectModule subjectModule);

    ResponseEntity<Subject> getSubjectByExample(Subject subject);

    ResponseEntity<Collection<Subject>> getSubjectByExampleCoeffAndTitle(String title, int coefficient);

    ResponseEntity<Collection<Subject>> getSubjectByTitleWithIgnoreCase(String title);
}
