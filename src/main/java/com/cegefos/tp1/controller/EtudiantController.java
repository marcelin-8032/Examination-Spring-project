package com.cegefos.tp1.controller;

import com.cegefos.tp1.dto.EtudiantDto;
import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.enums.Classe;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/etudiant")
public interface EtudiantController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createEtudiant(@RequestBody EtudiantDto etudiantDto);

    @GetMapping(value = "/findbyclasse/{classe}")
    Collection<Etudiant> getEtudiantByClass(@PathVariable("classe") Classe classe);

    @GetMapping(value = "/etudiants")
    Collection<Etudiant> getAllEtudiants();

}
