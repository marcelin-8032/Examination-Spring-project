package com.cegefos.tp1.controller;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.enums.Module;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/matiere")
public interface MatiereController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createMatiere(@RequestBody Matiere matiere);

    @PutMapping(value = "/update/{matiereId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateMatiereWithNumero(@PathVariable("matiereId") Integer matiereId, int numero);

    @GetMapping(value = "/matieresbycoeff")
    Collection<Matiere> getMatiereByCoeffBiggerThan(int coeff);

    @GetMapping(value = "/matieresbyexp")
    Optional<Matiere> getMatiereByExample(Example<?> example);

    @GetMapping(value = "/matieresbyexpcoeff")
    Optional<Matiere> getMatiereByCoefficent(Example<?> example);

    @GetMapping(value = "/matieresbyexpignorcase")
    Optional<Matiere> getMatiereByTitleWithIgnoreCase(Example<?> example);


    @GetMapping(value = "/matieres")
    Collection<Matiere> getMatieres();

    @GetMapping(value = "/matieresquerydsl3a/coeff/{coeff}/module/{module}")
    Collection<Matiere> getMatiereByCoeffBiggerThanAndIntituleDataAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3b/coeff/{coeff}/module/{module}")
    Collection<Matiere> getMatiereByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3c/module/{module}")
    Collection<Matiere> getMatiereIntituleDataAndModuleEq2(@PathVariable("module") Module module);

}
