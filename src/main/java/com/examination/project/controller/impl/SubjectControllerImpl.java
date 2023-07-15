package com.examination.project.controller.impl;

import com.examination.project.controller.SubjectController;
import com.examination.project.persistance.entities.SubjectEntity;
import com.examination.project.enums.Module;
import com.examination.project.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class SubjectControllerImpl implements SubjectController {

    @Autowired
    private MatiereService matiereService;

   /* @Autowired
    private MatiereMapper matiereMapper;*/


    public void createMatiere(@RequestBody SubjectEntity subjectEntity) {
        matiereService.createMatiere(subjectEntity);
    }


    public void updateMatiereWithNumero(@PathVariable("subjectId") Integer matiereId, int numero) {
        try {
            matiereService.updateMatiere(matiereId, numero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Collection<SubjectEntity> getMatiereByCoeffBiggerThan(int coeff) {
        return matiereService.getMatieresGreaterThanACoefficient(coeff);
    }


    public Optional<SubjectEntity> getMatiereByExample(Example<?> example) {
        return matiereService.getMatiereByExample(example);
    }


    public Optional<SubjectEntity> getMatiereByCoefficent(Example<?> example) {
        return matiereService.getMatiereByCoefficent(example);
    }


    public Optional<SubjectEntity> getMatiereByTitleWithIgnoreCase(Example<?> example) {
        return matiereService.getMatiereByTitleWithIgnoreCase(example);
    }


    public Collection<SubjectEntity> getMatieres() {
      /*  Collection<Matiere> matieres=this.matiereService.getAllMatieres();
        return    matiereMapper.toMatiereDtos(matieres);
        */
        return this.matiereService.getAllMatieres();
    }


    public Collection<SubjectEntity> getMatiereByCoeffBiggerThanAndIntituleDataAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module) {
        return matiereService.getMatiereCoeffBiggerIntituleEqDataModuleEq2(coeff, module);
    }


    public Collection<SubjectEntity> getMatiereByCoeffBiggerThanAndModule(@PathVariable("coeff") int coeff, @PathVariable("module") Module module) {
        return matiereService.getMatiereCoeffBiggerThanModuleEq2(coeff, module);
    }

    public Collection<SubjectEntity> getMatiereIntituleDataAndModuleEq2(@PathVariable("module") Module module) {
        return matiereService.getMatiereIntituleEqDataModuleEq2(module);
    }


}
