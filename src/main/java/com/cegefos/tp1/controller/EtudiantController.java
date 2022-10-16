package com.cegefos.tp1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.service.EtudiantService;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.createEtudiant(etudiant);
    }

    @GetMapping(value = "/findbyclasse/{classe}")
    public Collection<Etudiant> getEtudiantByClass(@PathVariable("classe") Classe classe) {
        return etudiantService.findEtudiantByClasse(classe);
    }


    @GetMapping(value = "/etudiants")
    public Collection<Etudiant> getAllEtudiants() {
        return etudiantService.findEtudiants();

    }


}
