package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.cegefos.tp1.persistance.entities.SubjectEntity;
import com.cegefos.tp1.enums.Module;

public interface MatiereService {

	void createMatiere(SubjectEntity subjectEntity);
	
	void updateMatiere(Integer id, int coefficient) throws Exception;
	
	Collection<SubjectEntity> getMatieresGreaterThanACoefficient(int coefficient);
	
	Optional<SubjectEntity> getMatiereByExample(Example<?> example);
	
	Optional<SubjectEntity> getMatiereByCoefficent(Example<?> example);
	
	Optional<SubjectEntity> getMatiereByTitleWithIgnoreCase(Example<?> example);
	
	Collection<SubjectEntity> getAllMatieres();
	
	Collection<SubjectEntity> getMatiereCoeffBiggerIntituleEqDataModuleEq2(int coeff, Module module);
	
	Collection<SubjectEntity> getMatiereCoeffBiggerThanModuleEq2(int coeff, Module module);
	
	Collection<SubjectEntity> getMatiereIntituleEqDataModuleEq2(Module module);
}
