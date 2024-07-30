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

@Tag(name = " Students API", description = "Management APIs for Student ")
public interface StudentHandler {

    @Operation(summary = "add student", description = "Return student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class))
            }),
    })
    ResponseEntity<Student> createStudent(@Parameter(name = "student", description = "adding a student to DB") Student student);

    @Operation(summary = "find all students", description = "Return all students",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
            }
    )
    ResponseEntity<Collection<Student>> getAllStudents();

    @Operation(summary = "finds Students by their Classe", description = "Return all students",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid class value")
            }
    )
    ResponseEntity<Collection<Student>> getStudentByClass(Classe classe);

    @Operation(summary = "add or update a student to an exam", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
            }
    )
    ResponseEntity<Void> addOrUpdateStudentToExam(Integer studentId, Integer examId);

    @Operation(summary = "delete student assigned to exam", description = "Return nothing",
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
            }
    )
    ResponseEntity<Void> deleteStudentAssignedToExam(Integer studentId, Integer examId);
}
