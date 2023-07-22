package com.examination.project.handler.controller.student;

import com.examination.project.entities.Student;
import com.examination.project.handler.persistance.enums.ClasseEntity;
import com.examination.project.usecases.student.StudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class StudentRestHandler implements StudentHandler {

    private final StudentUseCase studentUseCase;

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        studentUseCase.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Collection<Student>> getAllStudents() {
        studentUseCase.findStudents();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Collection<Student>> getStudentByClass(ClasseEntity classeEntity) {
//        studentUseCase.findStudentByClasse(classeEntity);
//        return new ResponseEntity<>(HttpStatus.FOUND);
        return null;
    }

}
