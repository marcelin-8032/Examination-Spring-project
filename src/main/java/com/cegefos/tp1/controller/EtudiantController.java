package com.cegefos.tp1.controller;

import com.cegefos.tp1.domains.Student;
import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/etudiant")
public interface EtudiantController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createEtudiant(@RequestBody Student student);

    @GetMapping(value = "/findbyclasse/{classe}")
    Collection<StudentEntity> getEtudiantByClass(@PathVariable("classe") Classe classe);

    @GetMapping(value = "/etudiants")
    Collection<StudentEntity> getAllEtudiants();

}
