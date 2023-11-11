package com.examination.project.infrastructure.handler.controller.v1.student;


import com.examination.project.domain.entities.Classe;
import com.examination.project.domain.entities.Student;
import com.examination.project.domain.usecases.v1.student.StudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/" + "students")
public class StudentRestHandler implements StudentHandler {
    private final StudentUseCase studentUseCase;

    @Override
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentUseCase.createStudent(student).fold(
                a -> ResponseEntity.badRequest().build(),
                student1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return studentUseCase.findStudents().fold(
                a -> ResponseEntity.badRequest().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/classe/{classe}")
    public ResponseEntity<Collection<Student>> getStudentByClass(@PathVariable("classe") Classe classe) {
        return studentUseCase.findStudentByClasse(classe).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

}
