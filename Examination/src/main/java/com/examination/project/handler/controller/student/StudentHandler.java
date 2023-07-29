package com.examination.project.handler.controller.student;

import com.examination.project.entities.Classe;
import com.examination.project.entities.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/student")
public interface StudentHandler {

    @Tag(name = " student", description = "add student")
    @Operation(method = "Post", summary = "add student", description = "this method allows to add the student")
    @ApiResponse(content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Student> createStudent(@RequestBody Student student);

    @GetMapping(value = "/etudiants")
    ResponseEntity<Collection<Student>> getAllStudents();

    @GetMapping(value = "/findbyclasse/{classe}")
    ResponseEntity<Collection<Student>> getStudentByClass(@PathVariable("classe") Classe classe);

}