package com.examination.project.service.impl;

import com.examination.project.persistance.entities.QSubjectEntity;
import com.examination.project.persistance.entities.SubjectEntity;
import com.examination.project.enums.Module;
import com.examination.project.persistance.repository.SubjectRepository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.examination.project.service.MatiereService;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void createMatiere(SubjectEntity subjectEntity) {
        subjectRepository.save(subjectEntity);
    }

    @Override
    public void updateMatiere(Integer id, int coefficient) throws Exception {

        SubjectEntity oldSubjectEntity = subjectRepository.findById(id)
                .orElseThrow(() -> new Exception("there is a problem in updating coefficient number"));
        ;
        oldSubjectEntity.setCoefficient(coefficient);
        subjectRepository.save(oldSubjectEntity);

    }


    @Override
    public Collection<SubjectEntity> getMatieresGreaterThanACoefficient(int coefficient) {
        return subjectRepository.findByCoefficientGreaterThan(coefficient);
    }


    @Override
    public Optional<SubjectEntity> getMatiereByExample(Example example) {
        //Matiere matiere=matiereRepository.findAll(null);

        return subjectRepository.findOne(example);
    }

    @Override
    public Optional<SubjectEntity> getMatiereByCoefficent(Example example) {
        var matiere = new SubjectEntity();
        matiere.setCoefficient(175);

        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());
        var matiereExampleCoeff = Example.of(matiere, matcher);


        return subjectRepository.findOne(example);
    }

    @Override
    public Optional<SubjectEntity> getMatiereByTitleWithIgnoreCase(Example example) {

        var matiere = new SubjectEntity();
        matiere.setCoefficient(200);
        matiere.setIntitule("DATA");

        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();

        var matiereExampleIntitule = Example.of(matiere, matcher);

        return subjectRepository.findOne(example);
    }

    @Override
    public Collection<SubjectEntity> getMatiereCoeffBiggerIntituleEqDataModuleEq2(int coeff, Module module) {
		QSubjectEntity qMatiere=new QSubjectEntity("matiere");
		BooleanExpression filterByCoeff=qMatiere.coefficient.gt(coeff);
		BooleanExpression filterByIntitule=qMatiere.intitule.contains("data");
		BooleanExpression filterByModule=qMatiere.module.eq(module);

		return (Collection<SubjectEntity>) subjectRepository.findAll(filterByCoeff.and(filterByIntitule).and(filterByModule));
    }

    @Override
    public Collection<SubjectEntity> getAllMatieres() {
        return subjectRepository.findAll();
    }

    @Override
    public Collection<SubjectEntity> getMatiereCoeffBiggerThanModuleEq2(int coeff, Module module) {

        QSubjectEntity qMatiere=new QSubjectEntity("matiere");
		BooleanExpression filterByCoeff=qMatiere.coefficient.gt(coeff);
		BooleanExpression filterByModule=qMatiere.module.eq(module);

		return (Collection<SubjectEntity>) subjectRepository.findAll(filterByCoeff.and(filterByModule));
    }

    @Override
    public Collection<SubjectEntity> getMatiereIntituleEqDataModuleEq2(Module module) {
        QSubjectEntity qMatiere=new QSubjectEntity("matiere");
		BooleanExpression filterByIntitule=qMatiere.intitule.contains("data");
		BooleanExpression filterByModule=qMatiere.module.eq(module);

		return (Collection<SubjectEntity>) subjectRepository.findAll(filterByIntitule.and(filterByModule));
    }

}
