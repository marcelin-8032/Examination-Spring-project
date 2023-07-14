package com.cegefos.tp1.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.enums.Classe;
import com.cegefos.tp1.persistance.repository.StudentRepository;
import com.cegefos.tp1.service.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createEtudiant(StudentEntity studentEntity) {
		studentRepository.save(studentEntity);
	}

	@Override
	public Collection<StudentEntity> findEtudiantByClasse(Classe classe) {
		return studentRepository.findEtudiantByClasse(classe);
	}

	@Override
	public Collection<StudentEntity> findEtudiants() {
		return studentRepository.findAll();
	}

}
