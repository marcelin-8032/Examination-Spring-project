package com.examination.project.infrastructure.handler.controller.v1.subject;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.mapper.SubjectMapper;
import com.examination.project.domain.usecasesV1.subject.SubjectUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.examination.project.domain.entities.Module;

import java.util.Collection;

@RestController
public class SubjectRestHandler implements SubjectHandler {

    @Autowired
    private SubjectUseCase subjectUseCase;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public ResponseEntity<Void> createSubject(Subject subject) {
        return subjectUseCase.createSubject(subject).fold(
                a -> ResponseEntity.badRequest().build(),
                subject1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    public ResponseEntity<Void> updateSubjectWithNumber(Integer subjectId, int number) throws Exception {
        return subjectUseCase.updateSubject(subjectId, number).fold(
                a -> ResponseEntity.notFound().build(),
                subject -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThan(int coeff) {
        return subjectUseCase.getSubjectsGreaterThanACoefficient(coeff).fold(
                a -> ResponseEntity.notFound().build(),
                subject -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    public ResponseEntity<Subject> getSubjectByExample(Example<?> example) {
        return subjectUseCase.getSubjectByExample(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    public ResponseEntity<Subject> getSubjectByCoeff(Example<?> example) {
        return subjectUseCase.getSubjectByCoefficient(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    public ResponseEntity<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example) {
        return subjectUseCase.getSubjectByTitleWithIgnoreCase(example).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> ResponseEntity.status(HttpStatus.FOUND).build()
        );
    }

    @Override
    public ResponseEntity<Collection<Subject>> getSubjects() {
        return subjectUseCase.getAllSubjects().fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule(
            int coeff, Module module) {
        return subjectUseCase.getSubjectCoeffBiggerTitleEqDataModuleEq2(coeff, module).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Subject>> getSubjectByCoeffBiggerThanAndModule(
            int coeff, Module module) {
        return subjectUseCase.getSubjectCoeffBiggerThanModuleEq2(coeff, module).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Subject>> getSubjectTitleDataAndModuleEq2(Module module) {
        return subjectUseCase.getSubjectTitleEqDataModuleEq2(module).fold(
                a -> ResponseEntity.notFound().build(),
                subjects -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }
}
