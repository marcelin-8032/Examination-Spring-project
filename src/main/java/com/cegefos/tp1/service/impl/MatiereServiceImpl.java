package com.cegefos.tp1.service.impl;

import com.cegefos.tp1.entity.Matiere;
import com.cegefos.tp1.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		Matiere OldMatiere = matiereRepository.findById(id).orElseThrow(() -> new Exception("there is a problem in updating coefficient number"));;
		OldMatiere.setCoefficient(coefficient);
		matiereRepository.save(OldMatiere);
		
	}
}
