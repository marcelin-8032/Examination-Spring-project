package com.cegefos.tp1.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.repository.ExamenRepository;
import com.cegefos.tp1.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	@Override
	public void createExamens(List<Examen> examens) {
		examenRepository.saveAll(examens);
	}

	@Override
	public Collection<Examen> getAllExamens() {
		return examenRepository.findAll();
	}

	@Override
	public Collection<Examen> getExamensByDate(Date date) {
		return examenRepository.findExamenByDateExam(date);
	}
	
	

}
