package com.cegefos.tp1.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.repository.ExamenRepository;
import com.cegefos.tp1.repository.SalleRepository;
import com.cegefos.tp1.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private SalleRepository salleRepository;

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

	@Override
	public Collection<Examen> getExamAtSalleAndAfterADate(Salle salle, Date date) {
		Integer id = 0;
		salle = salleRepository.findById(id).get();
		return examenRepository.findBySalleAndDateExamGreaterThan(salle, date);
	}

	@Override
	public Collection<Examen> getExamensAtRecentDataAtSpecificSalle(Salle salle) {
		return examenRepository.findTopBySalleOrderByDateExamDesc(salle);
	}

	@Override
	public Page<Examen> getAllExamensInPages(Pageable pageable) {
		pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
		return examenRepository.findAllExamens(pageable);
	}

	@Override
	public Page<Examen> getAllExamensBySalle(Integer id, Pageable pageable) {
		pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
		return examenRepository.findBysurveillant(id, pageable);
	}
	
	
	
	
	

}
