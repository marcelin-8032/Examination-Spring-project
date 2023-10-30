package com.examination.project.infrastructure.handler.controller.v1.student;

import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


public interface StudentHandler {

    @Tag(name = " student", description = "add student")
    @Operation(method = "Post", summary = "add student", description = "this method allows to add the student")
    @ApiResponse(content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    ResponseEntity<Student> createStudent(Student student);

    ResponseEntity<Collection<Student>> getAllStudents();

    ResponseEntity<Collection<Student>> getStudentByClass( Classe classe);

}