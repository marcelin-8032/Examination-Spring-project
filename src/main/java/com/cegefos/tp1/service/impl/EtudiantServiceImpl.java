package com.cegefos.tp1.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.repository.EtudiantRepository;
import com.cegefos.tp1.service.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Override
	public void createEtudiant(Etudiant etudiant) {
		etudiantRepository.save(etudiant);
	}

	@Override
	public Collection<Etudiant> findEtudiantByClasse(Classe classe) {
		return etudiantRepository.findEtudiantByClasse(classe);
	}

	@Override
	public Collection<Etudiant> findEtudiants() {
		return etudiantRepository.findAll();
	}

}
