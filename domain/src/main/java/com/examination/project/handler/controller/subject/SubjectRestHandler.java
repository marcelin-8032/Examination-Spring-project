package com.examination.project.handler.controller.subject;

import com.examination.project.entities.Subject;
import com.examination.project.mapper.SubjectMapper;
import com.examination.project.usecases.subject.SubjectUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class SubjectRestHandler implements SubjectHandler {

    @Autowired
    private SubjectUseCase subjectUseCase;

    @Autowired
    private SubjectMapper subjectMapper;


    @Override
    public void createSubject(@RequestBody Subject subject) {

        subjectUseCase.createSubject(subject);
    }


    @Override
    public void updateSubjectWithNumero(@PathVariable("subjectId") Integer matiereId, int numero) {
        try {
            subjectUseCase.updateSubject(matiereId, numero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public Collection<Subject> getSubjectByCoeffBiggerThan(int coeff) {
        return subjectUseCase.getSubjectsGreaterThanACoefficient(coeff);
    }

    @Override
    public Optional<Subject> getSubjectByExample(Example<?> example) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> getSubjectByCoefficent(Example<?> example) {
        return Optional.empty();
    }

    @Override
    public Optional<Subject> getSubjectByTitleWithIgnoreCase(Example<?> example) {
        return Optional.empty();
    }

    @Override
    public Collection<Subject> getSubjects() {
        return null;
    }

    @Override
    public Collection<Subject> getSubjectByCoeffBiggerThanAndIntituleDataAndModule(int coeff, Module module) {
        return null;
    }

    @Override
    public Collection<Subject> getSubjectByCoeffBiggerThanAndModule(int coeff, Module module) {
        return null;
    }

    @Override
    public Collection<Subject> getSubjectIntituleDataAndModuleEq2(Module module) {
        return null;
    }

    public Optional<Subject> getMatiereByExample(Example<?> example) {
        return subjectUseCase.getSubjectByExample(example);
    }


    public Optional<Subject> getMatiereByCoefficent(Example<?> example) {
        return subjectUseCase.getSubjectByCoefficient(example);
    }


    public Optional<Subject> getMatiereByTitleWithIgnoreCase(Example<?> example) {
        return subjectUseCase.getSubjectByTitleWithIgnoreCase(example);
    }


    public Collection<Subject> getMatieres() {
      /*  Collection<Matiere> matieres=this.matiereService.getAllSubjects();
        return    matiereMapper.toMatiereDtos(matieres);
        */
        return this.subjectUseCase.getAllSubjects();
    }


    public Collection<Subject> getMatiereByCoeffBiggerThanAndIntituleDataAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module) {
        return subjectUseCase.getSubjectCoeffBiggerIntituleEqDataModuleEq2(coeff, module);
    }


    public Collection<Subject> getMatiereByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module) {
        return subjectUseCase.getSubjectCoeffBiggerThanModuleEq2(coeff, module);
    }

    public Collection<Subject> getMatiereIntituleDataAndModuleEq2(@PathVariable("module") Module module) {
        return subjectUseCase.getSubjectTitleEqDataModuleEq2(module);
    }


}
