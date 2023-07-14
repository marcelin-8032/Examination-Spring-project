package com.cegefos.tp1.controller;

import com.cegefos.tp1.persistance.entities.SubjectEntity;
import com.cegefos.tp1.enums.Module;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/matiere")
public interface MatiereController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createMatiere(@RequestBody SubjectEntity subjectEntity);

    @PutMapping(value = "/update/{matiereId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateMatiereWithNumero(@PathVariable("matiereId") Integer matiereId, int numero);

    @GetMapping(value = "/matieresbycoeff")
    Collection<SubjectEntity> getMatiereByCoeffBiggerThan(int coeff);

    @GetMapping(value = "/matieresbyexp")
    Optional<SubjectEntity> getMatiereByExample(Example<?> example);

    @GetMapping(value = "/matieresbyexpcoeff")
    Optional<SubjectEntity> getMatiereByCoefficent(Example<?> example);

    @GetMapping(value = "/matieresbyexpignorcase")
    Optional<SubjectEntity> getMatiereByTitleWithIgnoreCase(Example<?> example);


    @GetMapping(value = "/matieres")
    Collection<SubjectEntity> getMatieres();

    @GetMapping(value = "/matieresquerydsl3a/coeff/{coeff}/module/{module}")
    Collection<SubjectEntity> getMatiereByCoeffBiggerThanAndIntituleDataAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3b/coeff/{coeff}/module/{module}")
    Collection<SubjectEntity> getMatiereByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3c/module/{module}")
    Collection<SubjectEntity> getMatiereIntituleDataAndModuleEq2(@PathVariable("module") Module module);

}
