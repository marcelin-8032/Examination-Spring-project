package com.examination.project.infrastructure.handler.controller.v1.subject;


import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.domain.entities.Subject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Example;
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

    ResponseEntity<Void> updateSubjectWithNumber(Integer subjectId, int number) throws Exception;


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff);

    ResponseEntity<Subject> getSubjectByExample(Example<?> example);


    ResponseEntity<Subject> getSubjectByCoeff(Example<?> example);


    ResponseEntity<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example);


    ResponseEntity<Collection<Subject>> getSubjects();


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            int coeff, SubjectModule subjectModule);


    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule( int coeff,
                                                                             SubjectModule subjectModule);


    ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(SubjectModule subjectModule);

}
