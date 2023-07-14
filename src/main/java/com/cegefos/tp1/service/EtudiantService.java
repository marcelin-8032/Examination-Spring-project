package com.cegefos.tp1.service;

import java.util.Collection;

import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;

public interface EtudiantService {

	void createEtudiant(StudentEntity studentEntity);

	Collection<StudentEntity> findEtudiants();

	Collection<StudentEntity> findEtudiantByClasse(Classe classe);

}
