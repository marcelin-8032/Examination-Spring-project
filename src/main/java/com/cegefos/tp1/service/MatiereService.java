package com.cegefos.tp1.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.cegefos.tp1.entity.Matiere;

public interface MatiereService {

	void createMatiere(Matiere matiere);
	
	void updateMatiere(Integer id, int coefficient) throws Exception;
	
	Collection<Matiere> getMatieresGreaterThanACoefficient(int coefficient);
	
	Optional<Matiere> getMatiereByExample(Example example);
	
	Optional<Matiere> getMatiereByCoefficent(Example example);
	
	Optional<Matiere> getMatiereByTitleWithIgonoreCase(Example example);
	
}
