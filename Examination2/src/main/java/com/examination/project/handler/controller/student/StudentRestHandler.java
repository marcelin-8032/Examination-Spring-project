package com.examination.project.handler.controller.student;


import com.examination.project.entities.Classe;
import com.examination.project.entities.Student;
import com.examination.project.usecases.student.StudentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentRestHandler implements StudentHandler {
    @Autowired
    private StudentUseCase studentUseCase;

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        return studentUseCase.createStudent(student).fold(
                a -> ResponseEntity.badRequest().build(),
                student1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return studentUseCase.findStudents().fold(
                a -> ResponseEntity.badRequest().build(),
                students -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Student>> getStudentByClass(Classe classe) {
        return studentUseCase.findStudentByClasse(classe).fold(
                a -> ResponseEntity.notFound().build(),
                class1 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

}
