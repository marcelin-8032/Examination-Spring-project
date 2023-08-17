package com.examination.project.usecases.subject;

import com.examination.project.entities.Subject;
import com.examination.project.mapper.SubjectMapper;
import com.examination.project.handler.persistance.subject.repository.SubjectRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubjectUseCaseImpl implements SubjectUseCase {
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void createSubject(Subject subject) {
        subjectRepository.save(subjectMapper.toSubjectEntity(subject));
    }

    @Override
    public void updateSubject(Integer id, int coefficient) throws Exception {
        if (subjectRepository.findById(id).isPresent()) {
            var oldSubjectDto = subjectRepository.findById(id).get();
            oldSubjectDto.setCoefficient(coefficient);
            subjectRepository.save(oldSubjectDto);
        } else {
            throw new Exception("there is a problem in updating coefficient number");
        }

    }


    @Override
    public Collection<Subject> getSubjectsGreaterThanACoefficient(int coefficient) {
        return subjectMapper.toSubjects(subjectRepository.findByCoefficientGreaterThan(coefficient));
    }


    @Override
    public Optional<Subject> getSubjectByExample(Example example) {
        //Matiere matiere=matiereRepository.findAll(null);

        return subjectRepository.findOne(example);
    }

    @Override
    public Optional<Subject> getSubjectByCoefficient(Example example) {
//        var matiere = new Subject();
//        matiere.setCoefficient(175);
//
//        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());
//        var matiereExampleCoeff = Example.of(matiere, matcher);
//
//
//        return subjectRepository.findOne(example);
        return Optional.empty();
    }

    @Override
    public Optional<Subject> getSubjectByTitleWithIgnoreCase(Example example) {

//        var matiere = new Subject();
//        matiere.setCoefficient(200);
//        matiere.setIntitule("DATA");
//
//        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();
//
//        var matiereExampleIntitule = Example.of(matiere, matcher);
//
//        return subjectRepository.findOne(example);
        return Optional.empty();
    }

    @Override
    public Collection<Subject> getSubjectCoeffBiggerIntituleEqDataModuleEq2(int coeff, Module module) {
//		QSubjectEntity qMatiere=new QSubjectEntity("matiere");
//		BooleanExpression filterByCoeff=qMatiere.coefficient.gt(coeff);
//		BooleanExpression filterByIntitule=qMatiere.intitule.contains("data");
//		BooleanExpression filterByModule=qMatiere.module.eq(module);
//
//		return (Collection<Subject>) subjectRepository.findAll(filterByCoeff.and(filterByIntitule).and(filterByModule));
        return List.of();
    }

    @Override
    public Collection<Subject> getAllSubjects() {
        return subjectMapper.toSubjects(subjectRepository.findAll());
    }

    @Override
    public Collection<Subject> getSubjectCoeffBiggerThanModuleEq2(int coeff, Module module) {

//        QSubjectEntity qMatiere=new QSubjectEntity("matiere");
//		BooleanExpression filterByCoeff=qMatiere.coefficient.gt(coeff);
//		BooleanExpression filterByModule=qMatiere.module.eq(module);
//
//		return subjectMapper.toSubjects(subjectRepository.findAll(filterByCoeff.and(filterByModule)));
        return List.of();
    }

    @Override
    public Collection<Subject> getSubjectTitleEqDataModuleEq2(Module module) {
//        QSubjectEntity qMatiere=new QSubjectEntity("matiere");
//		BooleanExpression filterByIntitule=qMatiere.intitule.contains("data");
//		BooleanExpression filterByModule=qMatiere.module.eq(module);
//
//		return (Collection<SubjectEntity>) subjectRepository.findAll(filterByIntitule.and(filterByModule));
        return List.of();
    }

}
