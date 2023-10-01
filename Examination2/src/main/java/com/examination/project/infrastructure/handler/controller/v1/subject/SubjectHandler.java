package com.examination.project.infrastructure.handler.controller.v1.subject;


import com.examination.project.domain.entities.Subject;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examination.project.domain.entities.Module;
import java.util.Collection;

@RequestMapping("/subject")
public interface SubjectHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createSubject(@RequestBody Subject subject);

    @PutMapping(value = "/update/{subjectId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateSubjectWithNumber(@PathVariable("subjectId") Integer subjectId, int number) throws Exception;

    @GetMapping(value = "/matieresbycoeff")
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff);

    @GetMapping(value = "/matieresbyexp")
    ResponseEntity<Subject> getSubjectByExample(Example<?> example);

    @GetMapping(value = "/subjectbyexpcoeff")
    ResponseEntity<Subject> getSubjectByCoeff(Example<?> example);

    @GetMapping(value = "/subjectbyexpignorcase")
    ResponseEntity<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example);

    @GetMapping(value = "/subjects")
    ResponseEntity<Collection<Subject>> getSubjects();

    @GetMapping(value = "/subjectsquerydsl3a/coeff/{coeff}/module/{module}")
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            @PathVariable("coeff") int coeff, @PathVariable("module") Module module);

    @GetMapping(value = "/subjectesquerydsl3b/coeff/{coeff}/module/{module}")
    ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff,
                                                                             @PathVariable("module") Module module);

    @GetMapping(value = "/subjectsquerydsl3c/module/{module}")
    ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(@PathVariable("module") Module module);

}
