package com.examination.project.controller.impl;

import com.examination.project.controller.StudentController;
import com.examination.project.domain.Student;
import com.examination.project.enums.Classe;
import com.examination.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Collection<Student>> getAllStudents() {
        studentService.findStudents();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Collection<Student>> getStudentByClass(Classe classe) {
        studentService.findStudentByClasse(classe);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

}
