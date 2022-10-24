package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.enums.Module;

public interface MatiereService {

	void createMatiere(Matiere matiere);
	
	void updateMatiere(Integer id, int coefficient) throws Exception;
	
	Collection<Matiere> getMatieresGreaterThanACoefficient(int coefficient);
	
	Optional<Matiere> getMatiereByExample(Example<?> example);
	
	Optional<Matiere> getMatiereByCoefficent(Example<?> example);
	
	Optional<Matiere> getMatiereByTitleWithIgnoreCase(Example<?> example);
	
	Collection<Matiere> getAllMatieres();
	
	Collection<Matiere> getMatiereCoeffBiggerIntituleEqDataModuleEq2(int coeff, Module module);
	
	Collection<Matiere> getMatiereCoeffBiggerThanModuleEq2(int coeff, Module module);
	
	Collection<Matiere> getMatiereIntituleEqDataModuleEq2(Module module);
}
