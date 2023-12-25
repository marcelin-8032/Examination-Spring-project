package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/" + "subjects")
public class SubjectRestHandler implements SubjectHandler {
    private final SubjectUseCase subjectUseCase;

    @Override
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createSubject(@RequestBody Subject subject) {
        return subjectUseCase.createSubject(subject).fold(
                a -> ResponseEntity.badRequest().build(),
                subject1 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    @PutMapping(value = "/update/{subjectId}")
    public ResponseEntity<Void> updateSubjectWithNumber(@PathVariable("subjectId") Integer subjectId, int number) throws Exception {
        return subjectUseCase.updateSubject(subjectId, number).fold(
                a -> ResponseEntity.notFound().build(),
                subject -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    @GetMapping(value = "/matieresbycoeff")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff) {
        return subjectUseCase.getSubjectsGreaterThanACoefficient(coeff).fold(
                a -> ResponseEntity.notFound().build(),
                subject -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    @GetMapping(value = "/matieresbyexp")
    public ResponseEntity<Subject> getSubjectByExample(Example<?> example) {
        return subjectUseCase.getSubjectByExample(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    @GetMapping(value = "/subjectbyexpcoeff")
    public ResponseEntity<Subject> getSubjectByCoeff(Example<?> example) {
        return subjectUseCase.getSubjectByCoefficient(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    @GetMapping(value = "/subjectbyexpignorcase")
    public ResponseEntity<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example) {
        return subjectUseCase.getSubjectByTitleWithIgnoreCase(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Subject>> getSubjects() {
        return subjectUseCase.getAllSubjects().fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/subjectsquerydsl3a/coeff/{coeff}/module/{module}")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            @PathVariable("coeff") int coeff, @PathVariable("module") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectCoeffBiggerTitleEqDataModuleEq2(coeff, subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/subjectesquerydsl3b/coeff/{coeff}/module/{module}")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(
            @PathVariable("coeff") int coeff,
            @PathVariable("module") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectCoeffBiggerThanModuleEq2(coeff, subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/subjectsquerydsl3c/module/{module}")
    public ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(@PathVariable("module") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectTitleEqDataModuleEq2(subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }
}
