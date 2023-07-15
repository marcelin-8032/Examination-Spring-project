package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.StudentController;
import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.persistance.mapper.StudentMapper;
import com.cegefos.tp1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
