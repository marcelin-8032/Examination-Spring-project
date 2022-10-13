package com.cegefos.tp1.service;

import java.util.Collection;

import com.cegefos.tp1.entity.Etudiant;
import com.cegefos.tp1.enums.Classe;

public interface EtudiantService {

	void createEtudiant(Etudiant etudiant);
	
	Collection<Etudiant> findEtudiantByClasse(Classe classe);
}
