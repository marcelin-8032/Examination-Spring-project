package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.StudentController;
import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.exception.ExaminationExceptionSanitize;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.persistance.mapper.StudentMapper;
import com.cegefos.tp1.service.StudentService;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void createEtudiant(@RequestBody Student student) {
        StudentEntity studentEntity = studentMapper.toStudentEntity(student);
        studentService.createEtudiant(studentEntity);
    }

    @Override
    public Either<ExaminationException, Student> createStudent(Student student) {
        return studentService.createStudent(student)
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }


    @Override
    public Collection<StudentEntity> getEtudiantByClass(@PathVariable("classe") Classe classe) {
        return studentService.findEtudiantByClasse(classe);
    }


    @Override
    public Collection<StudentEntity> getAllEtudiants() {
        return studentService.findEtudiants();

    }


}
