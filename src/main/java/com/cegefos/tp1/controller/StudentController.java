package com.cegefos.tp1.controller;

import com.cegefos.tp1.domain.Student;
import com.cegefos.tp1.exception.ExaminationException;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import io.vavr.control.Either;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/etudiant")
public interface StudentController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createEtudiant(@RequestBody Student student);


    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    Either<ExaminationException, Student> createStudent(@RequestBody Student student);


    @GetMapping(value = "/findbyclasse/{classe}")
    Collection<StudentEntity> getEtudiantByClass(@PathVariable("classe") Classe classe);

    @GetMapping(value = "/etudiants")
    Collection<StudentEntity> getAllEtudiants();

}
