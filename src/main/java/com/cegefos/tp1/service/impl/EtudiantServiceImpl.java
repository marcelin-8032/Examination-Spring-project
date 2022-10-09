package com.cegefos.tp1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.repository.EtudiantRepository;
import com.cegefos.tp1.service.EtudiantService;

public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Override
	public void createEtudiant(Etudiant etudiant) {
		etudiantRepository.save(etudiant);

	}

}
