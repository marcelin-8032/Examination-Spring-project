package com.examination.project.infrastructure.handler.controller.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface StudentHandler {

    @Tag(name = " Students API", description = "adding student ")
    @Operation(summary = "add student", description = "Returns a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class))
            }),
    })
    ResponseEntity<Student> createStudent(
            @Parameter(name = "student", description = "adding a student to DB")
            Student student);


    @Tag(name = " Students API", description = "retrieves all students ")
    @Operation(
            summary = "Finds all students",
            description = "All student can be found",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid status value")
            }
    )
    ResponseEntity<Collection<Student>> getAllStudents();


    @Tag(name = " Students API", description = "retrieves students by Classe ")
    @Operation(
            summary = "Finds Students by classe",
            description = "All student can be retrieved by thier classe",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid class value")
            }
    )
    ResponseEntity<Collection<Student>> getStudentByClass(Classe classe);
}
