package com.cegefos.tp1.service.impl;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.repository.MatiereRepository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.service.MatiereService;

@Service
public class MatiereServiceImpl implements MatiereService {

	@Autowired
	private MatiereRepository matiereRepository;

	@Override
	public void createMatiere(Matiere matiere) {
		matiereRepository.save(matiere);
	}

	@Override
	public void updateMatiere(Integer id, int coefficient) throws Exception {

		Matiere OldMatiere = matiereRepository.findById(id)
				.orElseThrow(() -> new Exception("there is a problem in updating coefficient number"));
		;
		OldMatiere.setCoefficient(coefficient);
		matiereRepository.save(OldMatiere);

	}


	@Override
	public Collection<Matiere> getMatieresGreaterThanACoefficient(int coefficient) {
		return matiereRepository.findByCoefficientGreaterThan(coefficient);
	}

	@Override
	public Optional<Matiere> getMatiereByExample(Example example) {
		//Matiere matiere=matiereRepository.findAll(null);
		
		return matiereRepository.findOne(example);
	}

	@Override
	public Optional<Matiere> getMatiereByCoefficent(Example example) {
		 var matiere = new Matiere();
	        matiere.setCoefficient(175);

	        var matcher = ExampleMatcher.matching().withMatcher("coefficient", exact());
	        var matiereExampleCoeff = Example.of(matiere, matcher);
		
		
		return matiereRepository.findOne(example);
	}

	@Override
	public Optional<Matiere> getMatiereByTitleWithIgonoreCase(Example example) {

		 var matiere = new Matiere();
	        matiere.setCoefficient(200);
	        matiere.setIntitule("DATA");

	        var matcher = ExampleMatcher.matchingAll().withIgnoreCase();

	        var matiereExampleIntitule = Example.of(matiere, matcher);
		
		return matiereRepository.findOne(example);
	}
	
	
	
	

}
