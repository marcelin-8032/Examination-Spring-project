package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.entities.SubjectModule;
import com.examination.project.domain.usecases.v1.subject.SubjectUseCase;
import lombok.RequiredArgsConstructor;
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
                subject1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @PutMapping(value = "/update/{subjectId}")
    public ResponseEntity<Void> updateSubjectCoefficient(@PathVariable("subjectId") Integer subjectId, int coefficient) throws Exception {
        return subjectUseCase.updateSubjectCoefficient(subjectId, coefficient).fold(
                a -> ResponseEntity.notFound().build(),
                subject -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    @GetMapping(value = "/subjectByCoeff")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(@RequestParam(value = "coeff") int coeff) {
        return subjectUseCase.getSubjectsGreaterThanACoefficient(coeff).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Subject>> getAllSubjects() {
        return subjectUseCase.getAllSubjects().fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/coeff/{coeff}/subjectModule/{subjectModule}/title=Chemistry")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            @PathVariable("coeff") int coeff, @PathVariable("subjectModule") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectCoeffBiggerTitleEqDataModuleEq2(coeff, subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/coeff/{coeff}/subjectModule/{subjectModule}")
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(
            @PathVariable("coeff") int coeff, @PathVariable("subjectModule") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectCoeffBiggerThanModuleEq2(coeff, subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/subjectModule/{subjectModule}")
    public ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(
            @PathVariable("subjectModule") SubjectModule subjectModule) {
        return subjectUseCase.getSubjectsTitleEqDataScienceModuleEq2(subjectModule).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/subjectByExp")
    public ResponseEntity<Subject> getSubjectByExample(@RequestBody Subject subject) {
        return subjectUseCase.getSubjectByExample(subject).fold(
                a -> ResponseEntity.notFound().build(),
                subjectFound -> new ResponseEntity<>(subjectFound.get(), HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/subjectByExpCoeffAndTitle")
    public ResponseEntity<Collection<Subject>> getSubjectByExampleCoeffAndTitle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "coefficient") int coefficient) {
        return subjectUseCase.getSubjectByCoefficient(title, coefficient).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/subjectByExpTitleIgnoreCase")
    public ResponseEntity<Collection<Subject>> getSubjectByTitleWithIgnoreCase(
            @RequestParam(name = "title") String title) {
        return subjectUseCase.getSubjectByTitleWithIgnoreCase(title).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }
}
