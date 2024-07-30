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

@Tag(name = " Subject API", description = "Management APIs for Subject")
public interface SubjectHandler {

    @Operation(summary = "add subject", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Void> createSubject(Subject subject);

    @Operation(summary = "update subject's coefficient", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Void> updateSubjectCoefficient(Integer subjectId, int number) throws Exception;

    @Operation(summary = "find subjects bigger than a coefficient", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff);

    @Operation(summary = "find all subjects", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getAllSubjects();

    @Operation(summary = "find subjects with coefficient bigger than and at subjectModule where Chemistry is title", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(int coeff, SubjectModule subjectModule);

    @Operation(summary = "find subjects with coefficient bigger than and at subjectModule", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(int coeff, SubjectModule subjectModule);

    @Operation(summary = "find subjects with title equal to Data_Science and at subjectModule", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(SubjectModule subjectModule);

    @Operation(summary = "find a subject by example", description = "Return a subject",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
            }
    )
    ResponseEntity<Subject> getSubjectByExample(Subject subject);

    @Operation(summary = "find subjects a title and coefficient using example", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByExampleCoeffAndTitle(String title, int coefficient);

    @Operation(summary = "find subjects a title with ignoreCase using Example", description = "find all subjects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Subject.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Subject")
            }
    )
    ResponseEntity<Collection<Subject>> getSubjectByTitleWithIgnoreCase(String title);
}
