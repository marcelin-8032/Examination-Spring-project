package com.examination.project.handler.controller.subject;

import com.examination.project.entities.Subject;
import com.examination.project.enums.Module;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/matiere")
public interface SubjectHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createSubject(@RequestBody Subject subject);

    @PutMapping(value = "/update/{subjectId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateSubjectWithNumero(@PathVariable("subjectId") Integer matiereId, int numero);

    @GetMapping(value = "/matieresbycoeff")
    Collection<Subject> getSubjectByCoeffBiggerThan(int coeff);

    @GetMapping(value = "/matieresbyexp")
    Optional<Subject> getSubjectByExample(Example<?> example);

    @GetMapping(value = "/matieresbyexpcoeff")
    Optional<Subject> getSubjectByCoefficent(Example<?> example);

    @GetMapping(value = "/matieresbyexpignorcase")
    Optional<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example);


    @GetMapping(value = "/matieres")
    Collection<Subject> getSubjects();

    @GetMapping(value = "/matieresquerydsl3a/coeff/{coeff}/module/{module}")
    Collection<Subject> getSubjectByCoeffBiggerThanAndIntituleDataAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3b/coeff/{coeff}/module/{module}")
    Collection<Subject> getSubjectByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module);


    @GetMapping(value = "/matieresquerydsl3c/module/{module}")
    Collection<Subject> getSubjectIntituleDataAndModuleEq2(@PathVariable("module") Module module);

}
